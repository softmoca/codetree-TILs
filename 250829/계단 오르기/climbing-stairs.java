import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[1001];
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < 1001; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3])%10007;
        }

        System.out.println(dp[n]);


    }
}