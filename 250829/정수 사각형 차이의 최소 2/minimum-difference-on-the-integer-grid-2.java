import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] grid;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        
        // 격자 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 모든 가능한 시작점에서 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean[][] visited = new boolean[N][N];
                dfs(i, j, grid[i][j], grid[i][j], visited);
            }
        }
        
        System.out.println(answer);
    }
    
    // DFS로 모든 경로 탐색
    static void dfs(int x, int y, int maxVal, int minVal, boolean[][] visited) {
        // 현재 차이가 이미 answer보다 크거나 같으면 가지치기
        if (maxVal - minVal >= answer) {
            return;
        }
        
        visited[x][y] = true;
        
        // 4방향 탐색 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        boolean canMove = false;
        
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 격자 범위 체크
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                canMove = true;
                int newMax = Math.max(maxVal, grid[nx][ny]);
                int newMin = Math.min(minVal, grid[nx][ny]);
                
                dfs(nx, ny, newMax, newMin, visited);
            }
        }
        
        // 더 이상 이동할 수 없는 경우 (경로의 끝)
        if (!canMove) {
            answer = Math.min(answer, maxVal - minVal);
        }
        
        visited[x][y] = false; // 백트래킹
    }
}