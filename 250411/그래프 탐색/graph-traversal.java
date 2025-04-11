import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<ArrayList<Integer>> graph;
    static boolean visited[];

    static void dfs(int x) {

        for (int w : graph.get(x)) {
            if (visited[w]) continue;

            visited[w] = true;
            dfs(w);


        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);
        for (int i = 0; i <= n; i++) {
          // System.out.println(visited[i]);
        }
        int cnt = 0;
        for (int i = 2; i < n + 1; i++) {
            if (visited[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
