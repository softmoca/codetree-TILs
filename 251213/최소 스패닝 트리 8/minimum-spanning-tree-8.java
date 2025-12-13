import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 500;

    public static boolean[] visited = new boolean[MAX_N + 1];

    public static int[] dist = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        // 그래프를 인접행렬로 표현
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], cost);  // 중복 간선 처리
            graph[b][a] = Math.min(graph[b][a], cost);
        }

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            // 1. 방문 안 한 노드 중 최소 거리 노드 찾기 (O(V))
            int minDist = Integer.MAX_VALUE;
            int curr = -1;
            for (int node = 1; node <= n; node++) {
                if (!visited[node] && dist[node] < minDist) {
                    minDist = dist[node];
                    curr = node;
                }
            }
            if (curr == -1) break;  // 더 이상 갈 곳 없음
            if (dist[curr] == Integer.MAX_VALUE) break;    // 연결되지 않은 그래프인 경우 (MST 구성 불가)
            visited[curr] = true;

            // mst 값을 갱신해줍니다.
            ans += dist[curr];

            // 2. 인접 노드 거리 갱신 (O(V))
            for(int next = 1; next <= n; next++) {
                // 간선이 존재하지 않는 경우에는 넘어갑니다.
                if (graph[curr][next] != Integer.MAX_VALUE && !visited[next]) {

                    dist[next] = Math.min(dist[next], graph[curr][next]);
                }
            }
        }

        System.out.print(ans);
    }
}

