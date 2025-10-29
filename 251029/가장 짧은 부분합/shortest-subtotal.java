import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int windowSum = 0;
        int res = Integer.MAX_VALUE;

        for (int left = 1; left <= n; left++) {

            while (true) {
                if (right >= n || windowSum >= s) {
                    break;
                }
                right++;
                windowSum += arr[right];
            }

            if (windowSum >= s) {
                res = Math.min(res, right - left + 1);
            }
            windowSum -= arr[left];


        }

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
}
