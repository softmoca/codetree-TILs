import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Pair>[] graph;

    static class Pair {
        int node, cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w)); // 양방향
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 1) 다익스트라로 dist만 구한다
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.cost == b.cost) return a.node - b.node;
            return a.cost - b.cost;
        });
        pq.offer(new Pair(A, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node, d = cur.cost;
            if (d > dist[u]) continue;
            for (Pair nx : graph[u]) {
                int v = nx.node, w = nx.cost;
                int nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new Pair(v, nd));
                }
            }
        }

        // 최단 거리 출력
        System.out.println(dist[B]);

        // 2) 최단경로 DAG에서 사전순으로 가장 앞선 경로를 DFS로 복원
        // 인접 리스트를 정점 번호 오름차순으로 정렬해두면 사전순 탐색이 쉬움
       

        List<Integer> path = new ArrayList<>();
        boolean found = dfsLexi(A, B, dist, path, new boolean[n + 1]);

        // 3) 경로 출력
        if (found) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) sb.append(' ');
                sb.append(path.get(i));
            }
            System.out.println(sb);
        } else {
            // dist[B]가 INF가 아니면 원칙적으로 항상 존재
            System.out.println(A); // 안전장치
        }
    }

    // 최단경로 DAG 위에서 A->B 사전순 DFS
    static boolean dfsLexi(int u, int B, int[] dist, List<Integer> out, boolean[] vis) {
        out.add(u);
        if (u == B) return true;

        vis[u] = true;
        for (Pair nx : graph[u]) {
            int v = nx.node, w = nx.cost;
            // 최단경로 조건만 따라간다
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w == dist[v]) {
                if (!vis[v]) {
                    if (dfsLexi(v, B, dist, out, vis)) return true; // 첫 경로가 사전순 최소
                }
            }
        }
        vis[u] = false;
        out.remove(out.size() - 1);
        return false;
    }
}
