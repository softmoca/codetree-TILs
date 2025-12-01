import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 1000;

    // 변수 선언:
    public static int n, q;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] parent = new int[MAX_N + 1];
    public static int[] depth = new int[MAX_N + 1];
    static int[][] cost = new int[MAX_N+1][MAX_N+1];

    // 트리 순회를 진행합니다.
    // 동시에 depth를 기록해줍니다.
    public static void dfs(int x) {
        // 노드 x의 자식들을 살펴봅니다.
        for (int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);

            // 이미 방문한 노드라면 패스합니다.
            if (visited[y])
                continue;

            // depth값을 갱신해주며
            // 재귀적으로 탐색합니다.
            visited[y] = true;
            depth[y] = depth[x] + 1;
            parent[y] = x;
            dfs(y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();

        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        // n - 1개의 에지 정보를 입력받습니다.
        for (int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int co = sc.nextInt();

            edges[x].add(y);
            edges[y].add(x);
            cost[x][y] = co;
            cost[y][x] = co;

        }

        // dfs 탐색을 진행하며
        // 각 노드의 depth를 계산합니다.
        visited[1] = true;
        depth[1] = 1;
        dfs(1);

        // q개의 쿼리가 주어집니다.
        q = sc.nextInt();
        while (q-- > 0) {
            // 가장 가까운 공통 조상을 구할 두 노드의 번호가 주어집니다.
            int aa = sc.nextInt();
            int bb = sc.nextInt();
            int a = aa;
            int b = bb;


            // Step 1.
            // 두 노드 a, b의 depth를 비교하며
            // depth가 더 큰 쪽을 위로 올리는 것을 반복하며 두 노드의 depth를 맞춰줍니다.
            while (depth[a] != depth[b]) {
                if (depth[a] > depth[b])
                    a = parent[a];
                else
                    b = parent[b];
            }

            // Step 2.
            // 두 노드 a, b가 일치해질떄까지
            // 한 칸씩 위로 올라갑니다.
            while (a != b) {
                a = parent[a];
                b = parent[b];
            }

            int res1 = find(aa, a);
            int res2 = find(bb, a);


            System.out.println(res1 + res2);
            // LCA 값을 출력합니다.
            //System.out.println(a);
        }
    }

    static int find(int start, int target) {
        int sum = 0;
        if (start == target) {
            return 0;
        }

        while (true) {
            int temp = parent[start];
            sum = sum + cost[start][temp];
            if (temp == target) {
                break;
            }


            start = temp;


        }


        return sum;


    }


}
