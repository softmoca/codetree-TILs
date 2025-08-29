import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int maxSum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];
        
        // 격자 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // (0,0)에서 시작 (1,1)을 0-based로 변환
        visited[0][0] = true;
        dfs(0, 0, grid[0][0]);
        
        System.out.println(maxSum);
    }
    
    static void dfs(int x, int y, int currentSum) {
        maxSum = Math.max(maxSum, currentSum);
        
        // 현재 위치에서 인접한 4방향 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 범위 체크 및 방문 여부 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, currentSum + grid[nx][ny]);
                visited[nx][ny] = false; // 백트래킹
            }
        }
    }
}