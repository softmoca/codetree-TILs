import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, m;
    static int[] arr;

    static boolean find(long target) {
        long cnt = 0;
        for (int x : arr) {
            cnt += target / x;
            if (cnt >= n) return true;
        }

        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long l = 1;
        long r = (long) Math.pow(10, 14);
        long res = Long.MAX_VALUE;
        while (l <= r) {

            long mid = l + (r - l) / 2;

            if (find(mid)) {
                r = mid - 1;
                res = Math.min(res, mid);
            } else {
                l = mid + 1;
            }
        }

        System.out.println(res);


    }
}
