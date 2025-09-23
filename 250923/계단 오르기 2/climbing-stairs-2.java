import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][4];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 4; j++) {

                if (j - 1 >= 0 && dp[i - 1][j - 1] != -1) {
                    dp[i][j] = dp[i - 1][j - 1] + arr[i];
                }

                if (i - 2 >= 0 && dp[i - 2][j] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + arr[i]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);


    }
}
