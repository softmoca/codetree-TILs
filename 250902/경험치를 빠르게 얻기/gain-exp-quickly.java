import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] e = new int[n];
        int[] t = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            e[i] = Integer.parseInt(st.nextToken());
            t[i] = Integer.parseInt(st.nextToken());
            len += t[i];
        }


        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = len; j >= 0; j--) {
                if (j - t[i] >= 0 && dp[j - t[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - t[i]] + e[i]);
                }
            }
        }


        int res = -1;
        for (int i = 0; i <= len; i++) {
            if (dp[i] != Integer.MAX_VALUE && dp[i] >= m) {
                res = i;
                break;
            }

        }
        System.out.println(res);


    }
}
