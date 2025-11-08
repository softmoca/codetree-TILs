import java.util.*;
import java.io.*;

class Pair {
    long cost, time;
    Pair(long cost, long time) { this.cost = cost; this.time = time; }

    // this > p ?
    boolean isGreaterThan(Pair p) {
        return this.cost > p.cost || (this.cost == p.cost && this.time > p.time);
    }
}

public class Main {
    static final long INF = (long)1e17 + 1;
    static final int MAX_M = 1000; // 정점(정류장) 번호 범위 1..1000

    static int a, b, n, m = MAX_M;

    // 인접 리스트: graph[u] = (v, wCost, wTime)
    static List<int[]>[] graph = new ArrayList[MAX_M + 1];

    static Pair[] dist = new Pair[MAX_M + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 그래프 초기화
        for (int i = 1; i <= m; i++) graph[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // 버스 정보 입력 → 간선 추가
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int fare = Integer.parseInt(st.nextToken());
            int stopNum = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] stops = new int[stopNum];
            for (int j = 0; j < stopNum; j++) stops[j] = Integer.parseInt(st.nextToken());

            // 같은 버스 내 j<k 모든 쌍에 간선 추가 (비용=fare, 시간=k-j)
            for (int j = 0; j < stopNum; j++) {
                for (int k = j + 1; k < stopNum; k++) {
                    int u = stops[j], v = stops[k];
                    int t = k - j;
                    graph[u].add(new int[]{v, fare, t});
                }
            }
        }

        // dist 초기화
        for (int i = 1; i <= m; i++) dist[i] = new Pair(INF, 0);
        dist[a] = new Pair(0, 0);

        // (요금,시간,정점) 사전식 우선순위 큐
        PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] != y[0]) return Long.compare(x[0], y[0]);   // cost
            if (x[1] != y[1]) return Long.compare(x[1], y[1]);   // time
            return Long.compare(x[2], y[2]);                      // node (tie-break)
        });
        pq.offer(new long[]{0L, 0L, a});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cc = cur[0], ct = cur[1];
            int u = (int)cur[2];

            // 현재 기록보다 나쁘면 스킵
            if (dist[u].cost < cc || (dist[u].cost == cc && dist[u].time < ct)) continue;

            for (int[] e : graph[u]) {
                int v = e[0];
                long nc = cc + e[1];
                long nt = ct + e[2];
                Pair cand = new Pair(nc, nt);
                if (dist[v].isGreaterThan(cand)) {
                    dist[v] = cand;
                    pq.offer(new long[]{nc, nt, v});
                }
            }
        }

        if (dist[b].cost == INF) {
            System.out.println("-1 -1");
        } else {
            System.out.println(dist[b].cost + " " + dist[b].time);
        }
    }
}
