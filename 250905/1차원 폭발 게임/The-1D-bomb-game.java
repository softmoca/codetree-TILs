import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, m;
    static int[] arr;
    static int[] checkTemp;
    static int len;

    static boolean check() {
        Arrays.fill(checkTemp, -1);

        boolean flag = false;
        int cnt = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i - 1] == arr[i]) {
                cnt++;
            } else {
                if (cnt >= m) {
                    flag = true;
                    for (int j = 0; j < cnt; j++) {
                        checkTemp[i - 1 - j] = 0;
                    }

                }
                cnt = 1;


            }


        }

        if (cnt >= m) {
            flag = true;
            for (int j = 0; j < cnt; j++) {
                checkTemp[len - 1 - j] = 0;
            }
        }


        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        checkTemp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        len = n;

        while (true) {

            if (check()) {
                Deque<Integer> q = new ArrayDeque<>();
                for (int i = 0; i < len; i++) {
                    if (checkTemp[i] != 0) {
                        q.addLast(arr[i]);
                    }

                }

                len = q.size();
                for (int i = 0; i < len; i++) {
                    arr[i] = q.pollFirst();
                }
                
                if(len == 0) break;


            } else {
                break;
            }


        }
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }

    }
}
