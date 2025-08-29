import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], arr[0][i]);
            dp[i][0] = Math.min(dp[i - 1][0], arr[i][0]);
        }
       // System.out.println();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int temp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.min(arr[i][j], temp);
            }
        }
        System.out.println(dp[n - 1][n - 1]);


    }
}
