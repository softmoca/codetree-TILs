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
        dp[4] = 71;
        dp[5] = 226;
        long sum;
        for (int i = 6; i < n + 1; i++) {
            if(i%2==0){
                sum = (dp[i - 1] * 2 + dp[i - 2] * 3 + dp[i - 3] * 2 + 2) % 1000000007;
                
            }else{
                sum = (dp[i - 1] * 2 + dp[i - 2] * 3 + dp[i - 3] * 2 ) % 1000000007;
            }
            
            
            
            
            for (int j = 4; i - j > 0; j += 2) {
                sum = (sum + dp[i - j] * 2) % 1000000007;
            }
            dp[i] = sum;

        }
        System.out.println(dp[n]);

    }
}
