import java.io.*;
import java.util.*;

public class Main {
    static int N, minV = 100, maxV = 1;
    static int[][] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        a = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                minV = Math.min(minV, a[i][j]);
                maxV = Math.max(maxV, a[i][j]);
            }
        }

        int lo = 0, hi = maxV - minV, ans = hi;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (feasible(mid)) { ans = mid; hi = mid - 1; }
            else lo = mid + 1;
        }
        System.out.println(ans);
    }

    // 차이 D로 가능한 어떤 [L, L+D]에서도 경로가 있으면 true
    static boolean feasible(int D) {
        for (int L = minV; L + D <= maxV; L++) {
            int R = L + D;
            if (!in(a[0][0], L, R) || !in(a[N-1][N-1], L, R)) continue;
            if (reachableWithDP(L, R)) return true;
        }
        return false;
    }

    // 오른쪽/아래만 이동 DP
    static boolean reachableWithDP(int L, int R) {
        boolean[][] dp = new boolean[N][N];
        if (!in(a[0][0], L, R)) return false;
        dp[0][0] = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!in(a[i][j], L, R)) { dp[i][j] = false; continue; }
                if (i == 0 && j == 0) continue;
                boolean fromUp = (i > 0) && dp[i-1][j];
                boolean fromLeft = (j > 0) && dp[i][j-1];
                dp[i][j] = fromUp || fromLeft;
            }
        }
        return dp[N-1][N-1];
    }

    static boolean in(int v, int L, int R) { return L <= v && v <= R; }
}
