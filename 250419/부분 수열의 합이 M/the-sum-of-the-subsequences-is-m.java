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
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {

                if (j - arr[i] < 0) continue;

                if (dp[j - arr[i]] == Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }

        }

        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }

    }
}
