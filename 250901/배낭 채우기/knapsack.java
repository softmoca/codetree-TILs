import java.io.*;
import java.util.*;

/*
1. 1차원 배열로 풀기 -> 모든 배열중 최대값 -> 끝값배로 출력 비교
2. 2차원배열로 풀기

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
            for (int j = m; j >= 0; j--) {
                dp[i][j] = dp[i-1][j];
                if (j - w[i] < 0) continue;
                if (dp[i - 1][j - w[i]] == -1) continue;
                dp[i][j] = dp[i - 1][j - w[i]] + v[i];
            }


        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        System.out.println(res);


    }
}
