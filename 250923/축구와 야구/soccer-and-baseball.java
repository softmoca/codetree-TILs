import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] soccer = new int[N];
        int[] baseball = new int[N];
        for (int i = 0; i < N; i++) {
            soccer[i] = sc.nextInt();
            baseball[i] = sc.nextInt();
        }

        final int S = 11, B = 9;
        int[][] dp = new int[S + 1][B + 1];
        for (int j = 0; j <= S; j++) Arrays.fill(dp[j], -1);
        dp[0][0] = 0;

        for (int i = 0; i < N; i++) {
            int[][] next = new int[S + 1][B + 1];
            for (int j = 0; j <= S; j++) Arrays.fill(next[j], -1);

            for (int j = 0; j <= S; j++) {
                for (int k = 0; k <= B; k++) {
                    if (dp[j][k] < 0) continue;

                    // 선택하지 않음
                    if (next[j][k] < dp[j][k]) next[j][k] = dp[j][k];

                    // 축구 선택
                    if (j < S) next[j + 1][k] = Math.max(next[j + 1][k], dp[j][k] + soccer[i]);

                    // 야구 선택
                    if (k < B) next[j][k + 1] = Math.max(next[j][k + 1], dp[j][k] + baseball[i]);
                }
            }
            dp = next;
        }

        System.out.println(dp[S][B]);
    }
}
