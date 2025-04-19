import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 9;

        for (int i = 6; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%10007;
        }
        System.out.println(dp[n]);


    }
}
