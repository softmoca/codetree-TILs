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

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(x -> x[1])
        );
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];  // 추가!
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[1] = 0;
        pq.offer(new int[]{1, 0});
        
        int ans = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int cost = curr[1];

            if (visited[u]) continue;
            
            visited[u] = true;
            ans += cost;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                if (!visited[v] && w < dist[v]) {  // 더 좋을 때만!
                    dist[v] = w;
                    pq.offer(new int[]{v, w});
                }
            }
        }

        System.out.println(ans);
    }
}