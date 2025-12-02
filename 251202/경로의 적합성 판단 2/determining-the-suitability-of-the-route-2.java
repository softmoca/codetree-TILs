import java.io.*;
import java.util.*;

/*

 */


public class Main {

    static List<Integer>[] graph;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        arr = new int[k];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);

        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        check = new boolean[n + 1];


        for (int i = 0; i < k - 1; i++) {
            int start = arr[i];
            int end = arr[i + 1];
            Arrays.fill(check, false);
            check[start] = true;
            dfs(start);
            if (!check[end]) {
                System.out.println(0);
                System.exit(0);
            }


        }
        System.out.println(1);

    }

    static boolean[] check;

    static void dfs(int startNode) {

        for (int next : graph[startNode]) {

            if (!check[next]) {
                check[next] = true;
                dfs(next);
            }
        }


    }


}
