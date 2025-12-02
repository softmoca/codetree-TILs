import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 간선 리스트 (LinkedList 사용)
        List<int[]> edges = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, cost});
        }

        // 비용 내림차순 정렬
        edges.sort((a, b) -> b[2] - a[2]);

        // 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 큰 간선부터 연결
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            union(a, b);

            if (find(start) == find(end)) {
                System.out.println(cost);
                return;
            }
        }
    }
}