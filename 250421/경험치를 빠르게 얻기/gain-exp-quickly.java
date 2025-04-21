import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] e = new int[n];
        int[] t = new int[n];
        int sumT = 0;
        for (int i = 0; i < n; i++) {
            e[i] = sc.nextInt();
            t[i] = sc.nextInt();
            sumT += t[i];
        }


        int[] dp = new int[sumT + 1];
        for (int i = 0; i < sumT + 1; i++) {
            dp[i] = -10;
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = sumT; j >= 0; j--) {

                if (t[i] > j) continue;
                if (dp[j - t[i]] == -10) continue;

                dp[j] = Math.max(dp[j], dp[j - t[i]] + e[i]);
            }
//            for (int j = 0; j < sumT + 1; j++) {
//                System.out.print(dp[j] + " ");
//            }
//            System.out.println();

        }


        int res = -1;

        for (int i = 0; i < sumT + 1; i++) {
            if (dp[i] >= m) {
                res = i;
                break;
            }

        }
        System.out.println(res);


    }
}
