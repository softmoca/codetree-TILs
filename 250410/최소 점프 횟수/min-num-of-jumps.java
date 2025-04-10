import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int res = Integer.MAX_VALUE;
    static List<Integer> answer = new ArrayList<>();

    static void choose(int currIdx, int cnt) {
        if (currIdx == n - 1) {
            //  System.out.println(cnt);
            res = Math.min(res, cnt);
            return;
        }
        //   if (currIdx > n - 1) return;


        answer.add(arr[currIdx]);


        for (int i = 1; i <= answer.get(answer.size() - 1); i++) {
            if (currIdx + i <= n - 1) {
                choose(currIdx + i, cnt + 1);
                if (currIdx + i != n - 1) {
                    answer.remove(answer.size() - 1);
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        choose(0, 0);

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
            
        }else{
            System.out.println(res);
        }

    }
}

