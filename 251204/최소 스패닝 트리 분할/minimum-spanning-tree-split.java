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


        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        List<Point> points = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y, cost));

        }

        points.sort(
                Comparator.comparing(
                        (Point p) -> p.cost
                )
        );


        List<Integer> res = new ArrayList<>();

        for (Point p : points) {
            int rootA = find(p.node1);
            int rootB = find(p.node2);

            if (rootA == rootB) {
                continue;
            }
            parent[rootA] = rootB;
            res.add(p.cost);

        }

        int target = 0;
        int d = 0;
        for (int x : res) {
            d = d + x;
            target = Math.max(target, x);
        }
        System.out.println(d - target);


    }


    static class Point {
        int node1, node2;
        int cost;

        Point(int node1, int node2, int cost) {
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
