import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        //dp[2] = 2;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - 1 - j];
            }
        }
        System.out.println(dp[n]);


    }
}
