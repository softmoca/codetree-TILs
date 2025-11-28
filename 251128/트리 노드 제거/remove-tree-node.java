import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_N = 50;

    // 변수 선언:
    public static int n;
    public static int ans;
    public static int root;
    public static int[] par = new int[MAX_N];
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N];
    public static boolean[] isDeleted = new boolean[MAX_N];

    // DFS를 통해 x 아래의 리프노드의 개수를 찾아줍니다.
    public static void dfs(int x) {
        // (루트 노드가 삭제되었을 때) 삭제된 노드는 스킵합니다.
        if (isDeleted[x])
            return;

        // x번 노드가 리프노드인지 판단합니다. 자신의 자식 노드가
        // 하나라도 남아 있을 경우 x번 노드는 리프노드가 아닙니다.
        boolean isLeaf = true;

        for (int i = 0; i < edges[x].size(); i++) {
            int y = edges[x].get(i);

            // 삭제된 노드는 스킵합니다.
            if (isDeleted[y])
                continue;

            dfs(y);
            isLeaf = false;
        }

        // 자신 노드가 리프 노드일 경우 답을 갱신합니다.
        if (isLeaf)
            ans++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();
        // n개의 간선 정보를 입력받습니다.
        for (int i = 0; i < n; i++) {
            int x, y;
            par[i] = sc.nextInt();
            x = i;
            y = par[i];

            // -1이 입력된 경우 루트 노드로 지정합니다.
            if (y == -1) {
                root = x;
                continue;
            }

            // 간선 정보를 인접리스트에 넣어줍니다.
            edges[y].add(x);
            edges[x].add(y);
        }

        // 노드를 제거합니다.
        int delNode = sc.nextInt();

        // 노드를 제거하는 방법에는 간선을 직접 끊어주는 등 여러 방법이 있습니다.
        // 여기서는 삭제되었는지 여부를 배열로 관리합니다.
        isDeleted[delNode] = true;

        // root 정점으로부터 리프노드의 개수를 찾습니다.
        dfs(root);

        System.out.print(ans);
    }
}
