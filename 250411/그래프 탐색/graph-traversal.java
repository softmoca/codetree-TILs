import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;

    static int[][] graph;
    static boolean[] visited;

    static void dfs(int x) {

        for (int i = 1; i < n + 1; i++) {
            if (graph[x][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }

        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        visited[1] = true;
        dfs(1);
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (visited[i] == true) cnt++;
        }
        System.out.println(cnt);

    }
}
