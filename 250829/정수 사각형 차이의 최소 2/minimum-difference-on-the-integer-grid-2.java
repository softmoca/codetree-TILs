import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] a;
    static int minV = 100, maxV = 1;
    static final int[] dx = {1, 0};
    static final int[] dy = {0, 1};

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
            if (existsPathWithDiff(mid)) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        System.out.println(ans);
    }

    // 차이 D가 허용될 때 어떤 [L, L+D] 구간으로도 (1,1)->(N,N) 경로가 존재하는지
    static boolean existsPathWithDiff(int D) {
        for (int L = minV; L + D <= maxV; L++) {
            int R = L + D;
            if (a[0][0] < L || a[0][0] > R) continue;
            if (a[N-1][N-1] < L || a[N-1][N-1] > R) continue;
            if (bfs(L, R)) return true;
        }
        return false;
    }

    static boolean bfs(int L, int R) {
        boolean[][] vis = new boolean[N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (x == N - 1 && y == N - 1) return true;
            for (int dir = 0; dir < 2; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (vis[nx][ny]) continue;
                int v = a[nx][ny];
                if (v < L || v > R) continue;
                vis[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return false;
    }
}
