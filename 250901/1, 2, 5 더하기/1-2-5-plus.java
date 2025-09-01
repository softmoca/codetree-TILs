import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 9;
        
        for (int i = 6; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 5])%10007;
        }

        System.out.println(dp[n]);
    }
}
