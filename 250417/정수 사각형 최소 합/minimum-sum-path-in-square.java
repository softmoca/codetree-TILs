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
        dp[0][n - 1] = arr[0][n - 1];
        for (int i = 1; i < n; i++) {
            dp[0][n - i - 1] = dp[0][n - i] + arr[0][n - 1 - i];
            dp[i][n - 1] = dp[i - 1][n - 1] + arr[i][n - 1];
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i < n; i++) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]) + arr[i][j];

            }
        }




        System.out.println(dp[n - 1][0]);


    }
}
