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
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[start].add(new Pair(end, v));
            graph[end].add(new Pair(start, v));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;

        // 거리 같으면 번호 작은 노드를 먼저 꺼내도록 정렬
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.cost == b.cost) return a.node - b.node;
            return a.cost - b.cost;
        });

        pq.offer(new Pair(A, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int curNode = cur.node;
            int curDist = cur.cost;
            if (curDist > dist[curNode]) continue;

            for (Pair next : graph[curNode]) {
                int nextNode = next.node;
                int newDist = curDist + next.cost;

                // 더 짧거나, 같은 거리지만 더 작은 번호의 부모라면 갱신
                if (newDist < dist[nextNode] ||
                    (newDist == dist[nextNode] && curNode < path[nextNode])) {
                    dist[nextNode] = newDist;
                    path[nextNode] = curNode;
                    pq.offer(new Pair(nextNode, newDist));
                }
            }
        }

        System.out.println(dist[B]);

        // 경로 복원
        List<Integer> route = new ArrayList<>();
        for (int cur = B; cur != 0; cur = path[cur]) {
            route.add(cur);
            if (cur == A) break;
        }
        Collections.reverse(route);
        for (int x : route) System.out.print(x + " ");
    }
}
