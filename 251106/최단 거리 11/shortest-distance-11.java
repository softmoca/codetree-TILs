import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static int n, m;
    static List<Edge>[] g; // 인접리스트(무방향: 양쪽 추가)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 무방향이면 양쪽 추가
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
        }

        // 사전순 복원을 위해 이웃을 정점 번호 오름차순으로 정렬
        for (int i = 1; i <= n; i++) {
            g[i].sort(Comparator.comparingInt(e -> e.to));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 도착
        int B = Integer.parseInt(st.nextToken()); // 시작

        // 1) 다익스트라: dist[B] = 0
        int INF = 1_000_000_000;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[B] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, B});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (d > dist[u]) continue;
            for (Edge e : g[u]) {
                int v = e.to, nd = d + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{nd, v});
                }
            }
        }

        // 2) 사전순 최단 경로 복원: A에서 B로 거꾸로,
        //    가장 작은 i를 선택: dist[i] + w(i,A) == dist[A]
        System.out.println(dist[A]); // 최단거리

        List<Integer> path = new ArrayList<>();
        int x = A;
        path.add(x);
        while (x != B) {
            int next = -1;
            // 무방향이면 g[x]에 인접한 i들이 모두 "들어올 수 있는 후보"
            for (Edge e : g[x]) {
                int i = e.to, w = e.w;
                if (dist[i] + w == dist[x]) { next = i; break; } // 정렬돼 있으니 첫 i가 사전순 최소
            }
            if (next == -1) break; // 경로 없음(이상 케이스)
            x = next;
            path.add(x);
        }

        // 뒤집어서 B -> ... -> A로 출력하거나, 아래처럼 역순으로 출력
        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(path.get(i));
        }
        System.out.println(sb.toString());
    }
}
