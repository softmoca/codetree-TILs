import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        str1 = " " + str1;  // 1-index
        str2 = " " + str2;

        int n = str1.length() - 1, m = str2.length() - 1;
        int[][] dp = new int[n + 1][m + 1];

        // LCS length DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i) == str2.charAt(j)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(str1.length() + str2.length() - dp[n][m] - 2);
    }
}
