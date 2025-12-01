import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 100000;

    // 간선 정보용 내부 클래스 (목적지, 가중치)
    static class Edge {
        int to;
        int w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static int n, q;
    public static ArrayList<Edge>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] parent = new int[MAX_N + 1];
    public static int[] depth = new int[MAX_N + 1];

    // 루트(1)부터 각 정점까지의 누적 거리
    public static long[] dist = new long[MAX_N + 1];

    // 트리 DFS : depth, parent, dist 계산
    public static void dfs(int x) {
        for (int i = 0; i < edges[x].size(); i++) {
            Edge e = edges[x].get(i);
            int y = e.to;
            int w = e.w;

            if (visited[y]) continue;

            visited[y] = true;
            parent[y] = x;
            depth[y] = depth[x] + 1;      // 간선 개수 기준 깊이
            dist[y] = dist[x] + w;        // 누적 거리
            dfs(y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        // (정점 u, v, 가중치 w)
        for (int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();     // 두 번째 문제는 가중치가 주어짐

            edges[x].add(new Edge(y, w));
            edges[y].add(new Edge(x, w));
        }

        // 루트 1에서 DFS 시작
        visited[1] = true;
        depth[1] = 0;      // 편하게 0으로 두어도 됨
        dist[1] = 0;
        parent[1] = 0;
        dfs(1);

        q = sc.nextInt();
        while (q-- > 0) {
            int aa = sc.nextInt();
            int bb = sc.nextInt();
            int a = aa;
            int b = bb;

            // 1단계 : 깊이를 맞추기
            while (depth[a] != depth[b]) {
                if (depth[a] > depth[b]) a = parent[a];
                else b = parent[b];
            }

            // 2단계 : 공통 조상 만날 때까지 같이 올리기
            while (a != b) {
                a = parent[a];
                b = parent[b];
            }
            int lca = a;

            // 경로 가중치 합 = root~aa + root~bb - 2 * root~lca
            long answer = dist[aa] + dist[bb] - 2L * dist[lca];
            System.out.println(answer);
        }
    }
}
