import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = sc.nextInt();
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[1][1] = 1;


        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {


                for (int ii = 1; ii < i; ii++) {
                    for (int jj = 1; jj < j; jj++) {
                        if (dp[ii][jj] == Integer.MIN_VALUE) {
                            continue;
                        }

                        if (arr[i][j] > arr[ii][jj]) {
                            dp[i][j] = Math.max(dp[ii][jj] + 1, dp[i][j]);
                        }


                    }

                }


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
