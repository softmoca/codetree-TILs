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
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int tempMax = -1;
                for (int k = 0; k <= i; k++) {
                    tempMax = Math.max(tempMax, dp[k][j - i]);
                }
                dp[i][j] = tempMax + arr[i];


            }


        }

        int res=0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        
        System.out.println(res);


    }
}
