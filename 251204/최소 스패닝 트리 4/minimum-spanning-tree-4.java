import com.sun.source.tree.UsesTree;

import java.io.*;
import java.util.*;

/*

 */


public class Main {

    static int[] parent;

    static class Pair {
        int node1, node2, cost;

        Pair(int node1, int node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            char x = st.nextToken().charAt(0);
            if (x == 'a') {
                arr[i] = 1;
            }

        }

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (arr[a] == arr[b]) continue;

            pairs.add(new Pair(a, b, cost));

        }


        pairs.sort(
                Comparator.comparing(
                        (Pair p) -> p.cost
                ));

        int res = 0;
        for (Pair p : pairs) {
            int a = p.node1;
            int b = p.node2;

            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) continue;

            parent[rootA] = rootB;
            res = res + p.cost;
        }

        int target = find(1);
        for (int i = 1; i < n + 1; i++) {
            if (find(i) != target) {
                System.out.println(-1);

                System.exit(0);
            }
        }


        System.out.println(res);


    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);

    }

    static void union(int a, int b) {


    }


}
