import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new int[1001];
        dp[1] = 2;
        dp[2] = 7;
        dp[3] = 22;
        dp[4] = 71;


        for (int i = 5; i < n + 1; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3 + dp[i - 3] * 2 + dp[i - 4] * 2) % 1000000007;
        }
        System.out.println(dp[n]);

    }
}
