import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static List<Integer>[] graph;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        graph = new List[10001];
        check = new boolean[10001];
        for (int i = 0; i <= 10000; i++) {
            graph[i] = new ArrayList<>();
        }

        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.add(a);
            nodes.add(b);
            graph[a].add(b);
        }

        for (int node : nodes) {
            check = new boolean[10001];
            check[node] = true;
            dfs(node);
            if (flag) break;
        }
        if (flag) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }


    }

    static boolean flag;

    static void dfs(int start) {

        if (flag) return;
        for (int node : graph[start]) {

            if (check[node]) {
                flag = true;
                return;
            }

            check[node] = true;
            dfs(node);


        }

    }


}
