import java.io.*;
import java.util.*;

/*

 */


public class Main {


    static List<int[]>[] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        graph = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, cost});
            graph[b].add(new int[]{a, cost});
        }

        check[start] = true;
        dfs(start, end, Integer.MAX_VALUE);
        System.out.println(res);

    }

    static long res = 0;

    static boolean[] check;

    static void dfs(int start, int end, int cost) {
        if (start == end) {
            res = Math.max(res, cost);
            return;
        }

        for (int[] now : graph[start]) {
            int next = now[0];
            int co = now[1];

            if (!check[next]) {
                check[next] = true;
                dfs(next, end, Math.min(cost, co));
                check[next] = false;

            }


        }


    }


}
