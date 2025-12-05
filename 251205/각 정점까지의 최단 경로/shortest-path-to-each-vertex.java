import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());

        // 인접 행렬 (V² 방식에 적합)
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], cost);  // 중복 간선 처리
            graph[b][a] = Math.min(graph[b][a], cost);
        }

        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        // V번 반복
        for (int i = 0; i < n; i++) {
            
            // 1. 방문 안 한 노드 중 최소 거리 노드 찾기 (O(V))
            int minDist = Integer.MAX_VALUE;
            int u = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    u = j;
                }
            }

            if (u == -1) break;  // 더 이상 갈 곳 없음
            visited[u] = true;

            // 2. 인접 노드 거리 갱신 (O(V))
            for (int v = 1; v <= n; v++) {
                if (graph[u][v] != Integer.MAX_VALUE && !visited[v]) {
                    if (dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}