import java.io.*;
import java.lang.reflect.Parameter;
import java.util.*;

public class Main {
    static class Pair {
        int wight, value;

        Pair(int wight, int value) {
            this.wight = wight;
            this.value = value;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int wight = sc.nextInt();
            int value = sc.nextInt();
            pairs[i] = new Pair(wight, value);
        }

        int[] dp = new int[m + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
dp[0]=0;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (pairs[i].wight <= j) {
                    if (dp[j - pairs[i].wight] == Integer.MIN_VALUE) continue;
                    dp[j] = Math.max(dp[j], dp[j - pairs[i].wight] + pairs[i].value);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < m + 1; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }

}
