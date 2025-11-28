import java.util.Scanner;
import java.util.ArrayList;

class Pair {
    int y, d;

    public Pair(int y, int d) {
        this.y = y;
        this.d = d;
    }
}

public class Main {
    public static final int MAX_N = 1000;
    
    // 변수 선언:
    public static int n, m;
    public static ArrayList<Pair>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];
    
    // DFS를 통해 st로부터 모든 정점까지의 거리를 탐색합니다.
    public static void dfs(int st, int x) {
        for(int i = 0; i < (int) edges[x].size(); i++) {
            int y = edges[x].get(i).y;
            int d = edges[x].get(i).d;

            // 이미 방문한 노드는 스킵합니다.
            if(visited[y]) continue;
            
            visited[y] = true;
    
            // st로부터의 거리를 갱신합니다.
            dist[st][y] = dist[st][x] + d;
            dfs(st, y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();
        
        // n - 1개의 간선 정보를 입력받습니다.
        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();

            // 간선 정보를 인접리스트에 넣어줍니다.
            edges[x].add(new Pair(y, d));
            edges[y].add(new Pair(x, d));
        }

        // 각 n개의 정점에 대해, 모든 노드간의 거리를 DFS로 갱신해줍니다.
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) 
                visited[j] = false;
            
            visited[i] = true;
            dfs(i, i);
        }

        // m개의 노드 쌍을 입력받고, 두 노드 쌍 간의 거리를 바로 출력해줍니다.
        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(dist[x][y]);
        }
    }
}
