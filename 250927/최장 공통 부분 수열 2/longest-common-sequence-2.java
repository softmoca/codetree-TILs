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

        // Reconstruct one LCS
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i) == str2.charAt(j)) { // 사용된 문자
                sb.append(str1.charAt(i));
                i--; j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) { // 위로 이동
                i--;
            } else { // 왼쪽으로 이동
                j--;
            }
        }

        System.out.println(sb.reverse().toString()); // 아무거나 한 개의 LCS 출력
    }
}
