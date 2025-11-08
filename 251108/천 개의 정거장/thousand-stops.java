import java.util.*;
import java.io.*;

class Pair {
    long cost, time;
    Pair(long cost, long time) { this.cost = cost; this.time = time; }
}

class Element {
    long cost, time;
    int node;
    Element(long cost, long time, int node) {
        this.cost = cost; this.time = time; this.node = node;
    }
}

public class Main {
    static final long INF = (long)1e17 + 1;
    static final int MAX_M = 1000;

    static int a, b, n, m = MAX_M;

    // 인접 리스트: graph[u] = (v, fare, time)
    static List<int[]>[] graph = new ArrayList[MAX_M + 1];
    static Pair[] dist = new Pair[MAX_M + 1];

    // u -> (v -> best (fare,time))
    static Map<Integer, Map<Integer, int[]>> best = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= m; i++) graph[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // ===== 간선 입력 + 중복 압축 =====
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int fare = Integer.parseInt(st.nextToken());
            int stopNum = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] stops = new int[stopNum];
            for (int j = 0; j < stopNum; j++) stops[j] = Integer.parseInt(st.nextToken());

            // 같은 버스 내 j<k 모든 쌍 후보
            for (int j = 0; j < stopNum; j++) {
                for (int k = j + 1; k < stopNum; k++) {
                    int u = stops[j], v = stops[k];
                    int t = k - j;

                    // u의 맵 가져오기
                    Map<Integer, int[]> row = best.computeIfAbsent(u, key -> new HashMap<>());
                    int[] cur = row.get(v); // {fare, time}

                    if (cur == null) {
                        row.put(v, new int[]{fare, t});
                    } else {
                        // lexicographic min: (fare, time)
                        if (fare < cur[0] || (fare == cur[0] && t < cur[1])) {
                            cur[0] = fare;
                            cur[1] = t;
                        }
                    }
                }
            }
        }

        // ===== 압축된 best를 인접 리스트로 변환 =====
        for (Map.Entry<Integer, Map<Integer, int[]>> e1 : best.entrySet()) {
            int u = e1.getKey();
            for (Map.Entry<Integer, int[]> e2 : e1.getValue().entrySet()) {
                int v = e2.getKey();
                int[] wt = e2.getValue(); // {fare, time}
                graph[u].add(new int[]{v, wt[0], wt[1]});
            }
        }

        // ===== 다익스트라 (요금 -> 시간 사전식 최소) =====
        for (int i = 1; i <= m; i++) dist[i] = new Pair(INF, 0);
        dist[a] = new Pair(0, 0);

        PriorityQueue<Element> pq = new PriorityQueue<>(
                Comparator.comparingLong((Element e) -> e.cost)
                        .thenComparingLong(e -> e.time)
        );
        pq.offer(new Element(0, 0, a));

        while (!pq.isEmpty()) {
            Element cur = pq.poll();
            long cc = cur.cost, ct = cur.time;
            int u = cur.node;

            if (dist[u].cost < cc || (dist[u].cost == cc && dist[u].time < ct)) continue;

            for (int[] e : graph[u]) {
                int v = e[0];
                long nc = cc + e[1];
                long nt = ct + e[2];

                if (dist[v].cost > nc || (dist[v].cost == nc && dist[v].time > nt)) {
                    dist[v] = new Pair(nc, nt);
                    pq.offer(new Element(nc, nt, v));
                }
            }
        }

        if (dist[b].cost == INF) System.out.println("-1 -1");
        else System.out.println(dist[b].cost + " " + dist[b].time);
    }
}
