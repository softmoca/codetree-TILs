import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static void dfs(int x) {

        visited[x] = true;

        for (int w : graph[x]) {
            if (!visited[w]) {
                dfs(w);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);
        int res = 0;
        for (int i = 0; i < n + 1; i++) {
            if (visited[i]) {
               
                res++;
            }
        }
        System.out.println(res-1);
    }
}
