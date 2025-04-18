import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

           


            int cnt = arr[i];
            if (dp[i] == 0 && arr[i] == 0) break;

            for (int j = i + 1; j < i + cnt + 1; j++) {
                if (j >= n) break;

                dp[j] = Math.max(dp[j], dp[i] + 1);
            }

            for (int j = 0; j < n; j++) {
                System.out.print(dp[j] + " ");
            }
            System.out.println();


        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);


    }
}
