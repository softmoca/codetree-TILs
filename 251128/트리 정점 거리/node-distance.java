import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*
방법 1 그냥 dfs
방법 2 루트로 부터 거리 구하기
 */


public class Main {

    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, cost});
            graph[b].add(new int[]{a, cost});

        }

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist = new int[n + 1];
            Arrays.fill(dist, -1);
            dist[a] = 0;
            dfs(a, b);
            System.out.println(dist[b]);


        }

    }

    static int[] dist;

    static void dfs(int start, int target) {

        for (int[] now : graph[start]) {
            int node = now[0];
            int cost = now[1];
            if (dist[node] == -1) {
                dist[node] = dist[start] + cost;
                dfs(node, target);
            }
        }

    }


}
