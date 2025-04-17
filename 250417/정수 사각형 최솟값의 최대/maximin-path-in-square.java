import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], arr[0][i]);
            dp[i][0] = Math.min(dp[i - 1][0], arr[i][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i - 1][j] > arr[i][j - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], arr[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], arr[i][j]);
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);


    }
}
