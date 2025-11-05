import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, m;
    static int[] arr;

    static int find(int target) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt = cnt + arr[i] / target;

        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int left = 1;
        int right = 0;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }


        int res = 0;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            int cnt = find(mid);

            if (cnt < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = Math.max(res, mid);
            }
        }
        System.out.println(res);


    }
}
