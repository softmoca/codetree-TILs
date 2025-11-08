import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static final int INF = 1_000_000_000;
    static List<Edge>[] g;
    static int N, M;

    static int[] dijkstra(int start, int forbidU, int forbidV) {
        // forbidU-forbidV 간선만 "2배"로 늘려서 사용하는 다익스트라
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        boolean[] vis = new boolean[N + 1];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], du = cur[1];
            if (vis[u]) continue;
            vis[u] = true;

            for (Edge e : g[u]) {
                int v = e.to;
                int w = e.w;

                // (forbidU, forbidV) 간선이면 2배 적용 (무방향이므로 양쪽 비교)
                if ((u == forbidU && v == forbidV) || (u == forbidV && v == forbidU)) {
                    w = w * 2;
                }

                int nd = du + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{v, nd});
                }
            }
        }
        return dist;
    }

    static int[] parent; // 최단경로 복원용

    static int[] dijkstraWithParent(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        boolean[] vis = new boolean[N + 1];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], du = cur[1];
            if (vis[u]) continue;
            vis[u] = true;

            for (Edge e : g[u]) {
                int v = e.to;
                int nd = du + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    parent[v] = u;          // v의 이전 정점 기록
                    pq.offer(new int[]{v, nd});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 무방향
            g[a].add(new Edge(b, w));
            g[b].add(new Edge(a, w));
        }

        // 1) 기본 최단거리 구하고, 1→N 최단경로를 parent로 복원
        int[] baseDist = dijkstraWithParent(1);
        int base = baseDist[N];

        // 2) 1→N 최단경로의 간선 목록을 뽑음
        List<int[]> pathEdges = new ArrayList<>(); // {u, v}
        int cur = N;
        while (parent[cur] != -1) {
            int u = parent[cur], v = cur;
            pathEdges.add(new int[]{u, v});
            cur = u;
        }

        // 3) 경로에 있는 각 간선을 2배로 바꿔서 다익스트라, 최댓값 갱신
        int best = base;
        for (int[] e : pathEdges) {
            int u = e[0], v = e[1];
            int[] dist = dijkstra(1, u, v);
            if (dist[N] < INF) best = Math.max(best, dist[N]);
        }

        // 4) 증가량 출력
        System.out.println(best - base);
    }
}
