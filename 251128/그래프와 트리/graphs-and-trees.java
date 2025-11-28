import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 개수
        M = Integer.parseInt(st.nextToken()); // 간선 개수

        // 인접 리스트 초기화 (1 ~ N)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 무방향 그래프 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N + 1];
        int treeCount = 0; // 트리인 연결 요소 개수

        // 모든 정점에 대해 연결 요소 탐색
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            // 새로운 연결 요소 시작
            VertexEdge ve = new VertexEdge();
            dfs(i, ve);

            int vCnt = ve.vertexCount;            // 정점 수
            int eCnt = ve.edgeDegreeSum / 2;      // 간선 수 (각 간선이 양쪽에서 한 번씩 더해졌으므로 /2)

            // 연결 요소가 트리인지 판단: 간선 수 = 정점 수 - 1
            if (eCnt == vCnt - 1) {
                treeCount++;
            }
        }

        System.out.println(treeCount);
    }

    // 연결 요소 안의 정점 수와 (각 정점의 degree 합)을 저장하기 위한 작은 클래스
    static class VertexEdge {
        int vertexCount = 0;   // 정점 개수
        int edgeDegreeSum = 0; // 모든 정점의 degree 합 (나중에 /2 하면 간선 개수)
    }

    // DFS로 하나의 연결 요소를 모두 방문하며
    // 정점 수와 degree 합을 누적
    static void dfs(int cur, VertexEdge ve) {
        visited[cur] = true;
        ve.vertexCount++;
        ve.edgeDegreeSum += graph[cur].size(); // 현재 정점의 degree 추가

        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next, ve);
            }
        }
    }
}
