import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n + 1; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[1] = 0;

        for (int i = 2; i < n + 1; i++) {

            for (int j = 1; j < i; j++) {
                if (dp[j] == Integer.MIN_VALUE) continue;

                if (j + arr[j] >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        if (dp[n] == Integer.MIN_VALUE) {
            System.out.println(1);
        } else {
            System.out.println(dp[n]);
            
        }


    }
}
