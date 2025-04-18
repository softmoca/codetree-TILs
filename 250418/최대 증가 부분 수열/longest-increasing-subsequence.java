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

        dp[0] = 1;


        for (int i = 1; i < n; i++) {
            int tempMax = 0;
            for (int j = i - 1; j >= 0; j--) {

                if (arr[j] < arr[i]) {
                    if (dp[j] > tempMax) {
                        tempMax = dp[j];
                    }
                }
            }
            dp[i] = tempMax + 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);


    }
}
