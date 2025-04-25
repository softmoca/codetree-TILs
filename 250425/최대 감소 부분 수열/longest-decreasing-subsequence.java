import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {

            for (int j = 1; j < i; j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }


        }
        int res = 0;
        for (int i = 0; i < n + 1; i++) {
            res = Math.max(dp[i], res);
        }

        System.out.println(res);
    }
}
