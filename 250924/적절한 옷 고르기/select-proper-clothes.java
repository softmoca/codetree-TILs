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

        int[][] arr = new int[n][3];
        int[][] dp = new int[m + 1][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i][0] = s;
            arr[i][1] = e;
            arr[i][2] = v;
        }

        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(dp[i], -1);
        }


        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 1) {
                dp[1][i] = 0;
            }
        }


        for (int i = 2; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                int start = arr[j][0];
                int end = arr[j][1];
                int v = arr[j][2];

                if (start <= i && i <= end) {
                    for (int k = 0; k < n; k++) {
                        if (dp[i - 1][k] == -1) continue;
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(arr[j][2] - arr[k][2]));
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[m][i]);
        }

        System.out.println(res);


    }
}
