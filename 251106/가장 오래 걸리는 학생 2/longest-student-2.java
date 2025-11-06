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
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[end].add(new Pair(start, v));

        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        pq.offer(new Pair(n, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int curNode = cur.node;
            int curDist = cur.cost;

            if (curDist > dist[curNode]) continue;

            for (Pair next : graph[curNode]) {
                int nextNode = next.node;
                int nextCost = next.cost;
                int newDist = curDist + nextCost;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new Pair(nextNode, newDist));
                }
            }
        }
        int res=0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        System.out.println(res);
    }
}
