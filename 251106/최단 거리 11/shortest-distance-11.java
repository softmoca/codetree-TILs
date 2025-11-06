import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Pair>[] graph;

    static class Pair {
        int node, cost;
        Pair(int node, int cost) { this.node = node; this.cost = cost; }
    }

    static int A, B;
    static int[] dist;
    static boolean[] visited;
    static List<Integer> path = new ArrayList<>();
    static boolean found = false; // 🚩 DFS 종료 제어용 전역 플래그

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
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
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        // 1️⃣ 다익스트라
        dist = new int[n + 1];
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

        // 2️⃣ 인접리스트 정렬 (사전순 탐색용)
        for (int i = 1; i <= n; i++)
            graph[i].sort(Comparator.comparingInt(p -> p.node));

        // 3️⃣ DFS로 사전순 첫 경로 찾기
        visited = new boolean[n + 1];
        path.add(A);
        visited[A] = true;
        dfs(A);

        // 4️⃣ 출력
        System.out.println(dist[B]);
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(path.get(i));
        }
    }

    // 🚩 void DFS: found=true가 되면 더 이상 탐색 안 함
    static void dfs(int cur) {
        if (found) return; // 이미 경로 찾았으면 멈춤
        if (cur == B) {    // 도착 시 탐색 종료
            found = true;
            return;
        }

        for (Pair nx : graph[cur]) {
            int v = nx.node, w = nx.cost;
            if (dist[cur] != Integer.MAX_VALUE && dist[cur] + w == dist[v] && !visited[v]) {
                visited[v] = true;
                path.add(v);
                dfs(v);
                if (found) return; // 재귀 전체 종료
                path.remove(path.size() - 1);
                visited[v] = false;
            }
        }
    }
}
