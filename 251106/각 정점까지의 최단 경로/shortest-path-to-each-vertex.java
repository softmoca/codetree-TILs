import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, m;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        graph = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[start].add(new int[]{end, v});
            graph[end].add(new int[]{start, v});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;


        Queue<int[]> pq = new PriorityQueue<>(
                Comparator.
                        comparing((int[] a) -> a[0])

        );


        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {


            int[] cur = pq.poll();
            int curDist = cur[0];
            int curNode = cur[1];

            if (curDist > dist[curNode]) continue;


            for (int[] next : graph[curNode]) {
                int node = next[0];
                int val = next[1];

                if (curDist + val < dist[node]) {
                    dist[node] = curDist + val;
                    pq.offer(new int[]{curDist + val, node});
                }

            }


        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(dist[i]);
        }


    }
}
