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
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;


        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);

        while (!pq.isEmpty()) {


            int target = pq.poll();
            int targetDist = dist[target];

            for (int[] next : graph[target]) {
                int node = next[0];
                int val = next[1];

                if (targetDist + val < dist[node]) {
                    dist[node] = targetDist + val;
                    pq.offer(node);
                }

            }


        }

        for (int i = 2; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(dist[i]);
        }


    }
}
