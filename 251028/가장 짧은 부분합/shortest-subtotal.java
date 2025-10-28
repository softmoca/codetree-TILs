import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int windowSum = 0;
        int res = Integer.MAX_VALUE;

        for (int left = 1; left <= n; left++) {
            while (right + 1 <= n && windowSum + arr[right + 1] < s) {
                windowSum += arr[right + 1];
                right++;
            }


            res = Math.min(res, right + 1 - left);


            windowSum -= arr[left];
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res + 1);

        }


    }
}
