import java.io.*;
import java.util.*;

public class Main {

    static List<int[]>[] graph;
    static boolean[] check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxCost = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, cost});
            graph[b].add(new int[]{a, cost});
            maxCost = Math.max(maxCost, cost);
        }

        // 이분 탐색
        long lo = 1, hi = maxCost, answer = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            check = new boolean[n + 1];
            check[start] = true;

            if (dfs(start, end, mid)) {
                answer = mid;   // 가능 → 더 높은 값 시도
                lo = mid + 1;
            } else {
                hi = mid - 1;   // 불가능 → 낮춰야 함
            }
        }

        System.out.println(answer);
    }

    // minCost 이상인 간선만 사용해서 도달 가능한지 DFS
    static boolean dfs(int cur, int end, long minCost) {
        if (cur == end) {
            return true;
        }

        for (int[] edge : graph[cur]) {
            int next = edge[0];
            int cost = edge[1];

            // 방문 안 했고, 비용이 기준 이상인 간선만 사용
            if (!check[next] && cost >= minCost) {
                check[next] = true;
                if (dfs(next, end, minCost)) {
                    return true;  // 도착 성공하면 바로 종료
                }
            }
        }

        return false;
    }
}
