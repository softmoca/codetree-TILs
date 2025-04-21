import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= 0; j--) {
                if (j < arr[i]) continue;
                if (dp[j - arr[i]] == false) continue;
                dp[j] = true;
            }

            for (int j = 0; j < sum / 2 + 1; j++) {
                //        System.out.print(dp[j] + " ");
            }
            //      System.out.println();

        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < sum / 2 + 1; i++) {
            if (dp[i]) {
                res = sum - i * 2;
            }


        }
        System.out.println(res);


    }
}
