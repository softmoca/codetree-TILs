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

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Pair[] pairs = new Pair[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(x, y);
        }

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeIdx1 = Integer.parseInt(st.nextToken());
            int nodeIdx2 = Integer.parseInt(st.nextToken());
            int rootA = find(nodeIdx1);
            int rootB = find(nodeIdx2);

            parent[rootA] = rootB;
        }

        List<Point> points = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                long x1 = pairs[i].x;
                long y1 = pairs[i].y;
                long x2 = pairs[j].x;
                long y2 = pairs[j].y;

                double dist = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

                points.add(new Point(i, j, dist));
            }
        }


        double res = 0;
        points.sort(
                Comparator.comparing(
                        (Point p) -> p.cost
                )
        );


        for (Point p : points) {
            int rootA = find(p.node1);
            int rootB = find(p.node2);

            if (rootA == rootB) {
                continue;
            }
            parent[rootA] = rootB;
            res = res + p.cost;
        }


        System.out.printf("%.2f", res);


    }


    static class Point {
        int node1, node2;
        double cost;

        Point(int node1, int node2, double cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }


}
