import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to;
        int cost;   // 요금 증가분
        int time;   // 탑승 시간 증가분

        Edge(int to, int cost, int time) {
            this.to = to;
            this.cost = cost;
            this.time = time;
        }
    }

    static final int MAX_STOP = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 각 버스의 정보 저장
        int[] fare = new int[N];
        int[][] stops = new int[N][];
        // 각 정류장에 어떤 (bus, idx)로 탈 수 있는지 역인덱스
        ArrayList<int[]>[] atStop = new ArrayList[MAX_STOP + 1];
        for (int s = 1; s <= MAX_STOP; s++) atStop[s] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            fare[i] = f;

            st = new StringTokenizer(br.readLine());
            stops[i] = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                stops[i][j] = Integer.parseInt(st.nextToken());
            }
            // 역인덱스 채우기: 정류장 s에서 (i,j)로 탑승 가능
            for (int j = 0; j < cnt; j++) {
                int s = stops[i][j];
                atStop[s].add(new int[]{i, j});
            }
        }

        // 노드 ID 매핑
        // 1..MAX_STOP : 정류장 노드
        // 그 뒤로 탑승 노드 (bus i, idx j)
        int[][] rideId = new int[N][];
        int base = MAX_STOP; // 마지막 정류장 ID
        int nextId = base + 1;
        for (int i = 0; i < N; i++) {
            rideId[i] = new int[stops[i].length];
            for (int j = 0; j < stops[i].length; j++) {
                rideId[i][j] = nextId++;
            }
        }
        int V = nextId - 1;

        // 그래프 구성
        ArrayList<Edge>[] g = new ArrayList[V + 1];
        for (int v = 0; v <= V; v++) g[v] = new ArrayList<>();

        // (1) 정류장 -> 탑승 노드 : 요금=fare[i], 시간=0
        for (int s = 1; s <= MAX_STOP; s++) {
            for (int[] info : atStop[s]) {
                int i = info[0], j = info[1];
                g[s].add(new Edge(rideId[i][j], fare[i], 0));
            }
        }
        // (2) 탑승 이동 (i,j) -> (i,j+1) : 요금 0, 시간 1
        // (3) 탑승 노드 -> 해당 정류장 하차 : 요금 0, 시간 0 (어느 지점에서도 하차 가능)
        for (int i = 0; i < N; i++) {
            int len = stops[i].length;
            for (int j = 0; j < len; j++) {
                int u = rideId[i][j];
                int s = stops[i][j];
                g[u].add(new Edge(s, 0, 0)); // 하차
                if (j + 1 < len) {
                    int v = rideId[i][j + 1];
                    g[u].add(new Edge(v, 0, 1)); // 다음 정류장으로 1초
                }
                // 마지막 정류장에 도달하면 반드시 하차 조건은
                // (j==len-1)에서 이동 간선이 없고 하차 간선만 있으므로 자연스럽게 강제됨
            }
        }

        // 다익스트라 (요금, 시간) 사전식
        final long INF = (long) 1e18;
        long[] bestCost = new long[V + 1];
        long[] bestTime = new long[V + 1];
        Arrays.fill(bestCost, INF);
        Arrays.fill(bestTime, INF);

        // 시작은 정류장 A
        bestCost[A] = 0;
        bestTime[A] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> {
            // x: {cost, time, node}
            if (x[0] != y[0]) return Long.compare(x[0], y[0]);
            if (x[1] != y[1]) return Long.compare(x[1], y[1]);
            return Long.compare(x[2], y[2]);
        });
        pq.offer(new long[]{0, 0, A});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long c = cur[0], t = cur[1];
            int u = (int) cur[2];
            if (c > bestCost[u] || (c == bestCost[u] && t > bestTime[u])) continue;

            for (Edge e : g[u]) {
                int v = e.to;
                long nc = c + e.cost;
                long nt = t + e.time;

                if (nc < bestCost[v] || (nc == bestCost[v] && nt < bestTime[v])) {
                    bestCost[v] = nc;
                    bestTime[v] = nt;
                    pq.offer(new long[]{nc, nt, v});
                }
            }
        }

        if (bestCost[B] == INF) {
            System.out.println("-1 -1");
        } else {
            System.out.println(bestCost[B] + " " + bestTime[B]);
        }
    }
}
