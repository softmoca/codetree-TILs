import java.util.Scanner;

public class Main {
    public static final int MAXN = 100005;
    public static final int INF = 1000000009;
    public static int n, k;
    public static int[] a = new int[MAXN];
    public static int[][] dp = new int[MAXN][15];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n과 k 값을 입력받습니다.
        n = sc.nextInt();
        k = sc.nextInt();
        // 보물 지도의 정보를 입력받습니다.
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        
        // dp 배열을 초기화 합니다.
        for (int i = 0; i <= n; i++) {
            for(int j = 0; j <= k; j++){
                dp[i][j] = -INF;
            }
        }

        // 초기 상태를 설정합니다.
        if (a[1] >= 0) {
            dp[1][0] = a[1];
        } else {
            dp[1][1] = a[1];
        }
        
        // 동적 프로그래밍을 이용해 최대 합을 구합니다.
        // dp[i][j] :: i번째 숫자를 마지막으로, 음수가 j번 나타났을 때 나타나는 연속합 중 최댓값
        int ans = a[1];
        for (int i = 2; i <= n; i++) {
            // a[i]가 0 이상인 경우
            if (a[i] >= 0) {
                // j=0 (음수 0개)인 경우, 이전 상태에서 음수 0개였거나 새로 시작합니다.
                dp[i][0] = Math.max(dp[i - 1][0] + a[i], a[i]);
                ans = Math.max(ans, dp[i][0]);
                
                // j>0 (음수 j개)인 경우
                for (int j = 1; j <= k; j++) {
                    if (dp[i - 1][j] != -INF) {
                        dp[i][j] = dp[i - 1][j] + a[i];
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            // a[i]가 음수인 경우
            else {
                // j=1 (음수 1개)인 경우, 이전 상태에서 음수가 0개였거나 새로 시작합니다.
                dp[i][1] = Math.max(dp[i - 1][0] + a[i], a[i]);
                ans = Math.max(ans, dp[i][1]);

                // j>1 (음수 j개)인 경우
                for (int j = 2; j <= k; j++) {
                    if (dp[i - 1][j - 1] != -INF) {
                        dp[i][j] = dp[i - 1][j - 1] + a[i];
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }

        // 최종 결과를 출력합니다.
        System.out.println(ans);
    }
}
