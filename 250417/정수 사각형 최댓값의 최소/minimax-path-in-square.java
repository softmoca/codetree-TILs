import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(arr[0][i], dp[0][i - 1]);
            dp[i][0] = Math.max(arr[i][0], dp[i - 1][0]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(arr[i][j],
                        Math.min(dp[i - 1][j], dp[i][j - 1])
                );

            }
        }
        System.out.println(dp[n - 1][n - 1]);

    }
}
