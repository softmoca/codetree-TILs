import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[1001];
        dp[1] = 2;
        dp[2] = 7;
        dp[3] = 22;
        long sum;
        for (int i = 4; i < n + 1; i++) {
            sum = (dp[i - 1] * 2 + dp[i - 2] * 3 + 2) % 1000000007;
            for (int j = 3; i - j > 0; j++) {
                sum = (sum + dp[i - j] * 2) % 1000000007;
            }
            dp[i] = sum;

        }
        System.out.println(dp[n]);

    }
}
