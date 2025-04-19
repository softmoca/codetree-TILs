import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m + 1; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= arr[j]) {
                    dp[i] = Math.max(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
        if (dp[m] == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }


    }
}
