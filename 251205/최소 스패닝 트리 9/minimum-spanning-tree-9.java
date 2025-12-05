import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인접 리스트
        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, cost});
            graph[b].add(new int[]{a, cost});
        }

        // 프림 (우선순위 큐)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(x -> x[1])
        );
        boolean[] visited = new boolean[n + 1];
        
        // 시작점 1에서 출발
        pq.offer(new int[]{1, 0});
        
        int ans = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {
            int[] curr = pq.poll();
            int u = curr[0];
            int cost = curr[1];

            if (visited[u]) continue;  // 이미 MST에 포함됨
            
            visited[u] = true;
            ans += cost;
            count++;

            // 인접 노드들을 큐에 추가
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                if (!visited[v]) {
                    pq.offer(new int[]{v, w});
                }
            }
        }

        System.out.println(ans);
    }
}