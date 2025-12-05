import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 500;

    // 변수 선언
    public static int n, m;
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

        // 그래프에 있는 모든 노드들에 대해
        // 초기값을 전부 아주 큰 값으로 설정
        // INT_MAX 그 자체로 설정하면
        // 후에 덧셈 진행시 overflow가 발생할 수도 있으므로
        // 적당히 큰 숫자로 적어줘야함에 유의!
        for(int i = 1; i <= n; i++)
            dist[i] = (int)1e9;

        // 시작위치에는 dist값을 0으로 설정
        dist[1] = 0;

        // O(|V|^2) 프림 코드
        int ans = 0;
        for(int i = 1; i <= n; i++) {
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

            // mst 값을 갱신해줍니다.
            ans += dist[u];

            // 최솟값에 해당하는 정점에 연결된 간선들을 보며
            // 시작점으로부터의 최솟값을 갱신해줍니다.
            for(int j = 1; j <= n; j++) {
                // 간선이 존재하지 않는 경우에는 넘어갑니다.
                if(graph[u][j] == Integer.MAX_VALUE)
                    continue;

                dist[j] = Math.min(dist[j], graph[u][j]);
            }
        }

        System.out.print(ans);
    }
}
