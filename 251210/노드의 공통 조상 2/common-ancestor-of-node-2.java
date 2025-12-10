import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_H = 17;
    public static final int MAX_N = 100000;

    // 변수 선언:
    public static int n, q;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static int[] depth = new int[MAX_N + 1];

    // parent[h][i] : i번 노드에서 2^h번 부모를 따라 위로 올라갔을 때의 노드 번호를 관리합니다.
    public static int[][] parent = new int[MAX_H + 1][MAX_N + 1];

    public static void dfs(int x) {
        for (int nextNode : edges[x]) {
            if (depth[nextNode] == -1) {
                depth[nextNode]=depth[x]+1;
                parent[0][nextNode]=x;
                dfs(nextNode);
            }
        }
    }

    // a와 b의 LCA를 구해줍니다.
    public static int lca(int a, int b) {
        // Step 0.
        // 노드 a의 높이가 더 같거나 커지도록 만들어줍니다.
        if(depth[a] < depth[b])
            return lca(b, a);

        // Step 1.노드 a의 높이를 노드 b의 높이까지 끌어올려줍니다.
        for(int h = MAX_H; h >= 0; h--) {
            if(depth[a] - depth[b] >= (1 << h))
                a = parent[h][a];
        }

        if(a == b)     // 이미 a와 b가 일치한다면  바로 그 값을 반환합니다.
            return a;

        // Step 2.
        // 두 노드 a, b가 일치해지기 직전까지 위로 올라갑니다.
        for(int h = MAX_H; h >= 0; h--) {
            if(parent[h][a] != parent[h][b]) {
                a = parent[h][a];
                b = parent[h][b];
            }
        }
        
        return parent[0][a];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            edges[x].add(y);
            edges[y].add(x);
        }

        Arrays.fill(depth,-1);
        depth[1] = 1;

        dfs(1);

        for(int h = 1; h <= MAX_H; h++) {
            for(int i = 1; i <= n; i++)
                parent[h][i] = parent[h - 1][parent[h - 1][i]];
        }

        // q개의 질의에 대해 답을 구해줍니다.
        q = sc.nextInt();
        while(q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(lca(a, b));
        }
    }
}
