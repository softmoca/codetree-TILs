import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;  // 이미 같은 집합 (사이클!)
        parent[rootA] = rootB;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 간선 리스트
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, cost});
        }

        // 비용 오름차순 정렬 (O(E log E))
        edges.sort((a, b) -> a[2] - b[2]);

        // Union-Find 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 크루스칼
        int ans = 0;
        int edgeCount = 0;
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if (union(a, b)) {          // 사이클 아니면 추가
                ans += cost;
                edgeCount++;
                if (edgeCount == n - 1) break;  // MST 완성
            }
        }

        System.out.println(ans);
    }
}