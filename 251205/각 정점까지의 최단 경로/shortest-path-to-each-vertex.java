import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        int startNode = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new int[] {b,cost});
            graph[b].add(new int[] {a,cost});
        }




        Queue<int[]> pq = new PriorityQueue<>(
                Comparator.comparing(
                        (int[]  x) -> x[1]
                )
        );

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;
        pq.offer(new int[]{startNode, 0});



        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int currNode = curr[0];
            int currCost = curr[1];

    //        if (dist[currNode] < currCost) continue;


            for (int[] next : graph[currNode]) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (dist[nextNode] > currCost + nextCost) {
                    dist[nextNode] = currCost + nextCost;
                    pq.offer( new int[] {nextNode,currCost+nextCost}    );
                }
            }


        }
        for (int i = 1; i <=n; i++) {
            if(dist[i]==Integer.MAX_VALUE){
                System.out.println(-1);
            }else {
                System.out.println(dist[i]);
            }
        }


    }
}
