import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

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

        int nodeCnt = n * m;
        parent = new int[nodeCnt + 1];
        for (int i = 0; i < nodeCnt + 1; i++) {
            parent[i] = i;
        }

        List<Pair> pairs = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m - 1; j++) {

                int cost = Integer.parseInt(st.nextToken());
                int node1 = i * m + j + 1;
                int node2 = i * m + j + 2;
                pairs.add(new Pair(node1, node2, cost));
            }
        }


        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int cost = Integer.parseInt(st.nextToken());
                int node1 = i * m + j + 1;
                int node2 = (i + 1) * m + j + 1;
                pairs.add(new Pair(node1, node2, cost));
            }
        }

        pairs.sort(
                Comparator.comparing(
                        (Pair p) -> p.cost
                )
        );
        int res = 0;

        for (Pair p : pairs) {
            int rootA = find(p.node1);
            int rootB = find(p.node2);
            if (rootA == rootB) {
                continue;
            }
            res = res + p.cost;
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

}

/*

3 4
1 5 7
1 1 8
5 1 9
5 1 1 10
1 1 5 11

 */
