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


        Pair[] pairs = new Pair[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(a, b, cost);
        }


        Arrays.sort(pairs,
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
            res += p.cost;
            parent[rootA] = rootB;


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
