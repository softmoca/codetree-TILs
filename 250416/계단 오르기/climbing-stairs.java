import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;
        for (int i = 5; i < n + 1; i++) {
dp[i] = (dp[i - 2] + dp[i - 3]) % 10007;
        }
        System.out.println(dp[n]);

    }
}
