import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
//            for (int j = 0; j < m + 1; j++) {
//                System.out.print(dp[j] + " ");
//            }
//            System.out.println();

        }

        System.out.println(dp[m]);


    }
}
