import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] a = new int[1005][5];
    public static int[][] dp = new int[1005][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3; j++)
                a[i][j] = sc.nextInt();
        }

        dp[1][1] = a[1][1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    // 이전 층과 같은 방을 고르지 않는 경우에 대해 계산합니다.
                    if (j != k) {
                        dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + a[i + 1][k]);
                    }
                }
            }
        }

        // 최종적으로 가능한 최대 점수를 계산합니다.
        int ans1 = 0;
        for (int j = 2; j <= 3; j++) {
            ans1 = Math.max(ans1, dp[n][j]);
        }

        dp = new int[1005][5];
        dp[1][2] = a[1][2];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    // 이전 층과 같은 방을 고르지 않는 경우에 대해 계산합니다.
                    if (j != k) {
                        dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + a[i + 1][k]);
                    }
                }
            }
        }
        int ans2 = 0;
        for (int j = 1; j <= 3; j++) {
            if(j==2) continue;
            ans2 = Math.max(ans2, dp[n][j]);
        }


        dp = new int[1005][5];
        dp[1][3] = a[1][3];


        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    // 이전 층과 같은 방을 고르지 않는 경우에 대해 계산합니다.
                    if (j != k) {
                        dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + a[i + 1][k]);
                    }
                }
            }
        }
        int ans3 = 0;
        for (int j = 1; j <= 2; j++) {
            ans3 = Math.max(ans3, dp[n][j]);
        }

        int ans = Math.max(ans1, Math.max(ans2, ans3));

        // 계산된 최대 점수를 출력합니다.
        System.out.println(ans);
    }
}
