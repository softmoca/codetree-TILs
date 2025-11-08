import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*

 */


public class Main {

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());


        List<Pair>[] graph = new ArrayList[n + 1];
        List<Pair>[] graph2 = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<Pair>();
            graph2[i] = new ArrayList<Pair>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Pair(b, cost));
            graph2[b].add(new Pair(a, cost));

        }


        Queue<Pair> pq = new PriorityQueue<>(
                Comparator.comparing(
                        (Pair p) -> p.cost
                )
        );

        int[] dist = new int[n + 1];
        int[] dist2 = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist[x] = 0;
        dist2[x] = 0;

        pq.offer(new Pair(x, 0));


        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int currNode = curr.node;
            int currCost = curr.cost;

            if (dist[currNode] < currCost) continue;


            for (Pair next : graph[currNode]) {
                int nextNode = next.node;
                int nextCost = next.cost;

                if (dist[nextNode] > currCost + nextCost) {
                    dist[nextNode] = currCost + nextCost;
                    pq.offer(new Pair(nextNode, currCost + nextCost));
                }
            }


        }


        pq.offer(new Pair(x, 0));


        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int currNode = curr.node;
            int currCost = curr.cost;

            if (dist[currNode] < currCost) continue;


            for (Pair next : graph2[currNode]) {
                int nextNode = next.node;
                int nextCost = next.cost;

                if (dist2[nextNode] > currCost + nextCost) {
                    dist2[nextNode] = currCost + nextCost;
                    pq.offer(new Pair(nextNode, currCost + nextCost));
                }
            }


        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;

            if (dist[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                res = Math.max(res, dist[i] + dist2[i]);
            }


        }

        System.out.println(res);


    }
}
