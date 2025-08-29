import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[1001];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3) % 1000000007;

            for (int j = 0; j <= i - 3; j++) {
                dp[i] = (dp[i] + dp[j] * 2) % 1000000007;
            }

            
        }
        System.out.println(dp[n]);
    }
}