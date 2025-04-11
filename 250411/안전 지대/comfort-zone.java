import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visited;
    static int maxK = Integer.MIN_VALUE;
    static int maxKCnt = Integer.MIN_VALUE;
    static int cnt = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y, int h) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && board[nx][ny] > h) {
                visited[nx][ny] = true;
                dfs(nx, ny, h);
            }


        }


    }

    static void initVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int k = 1; k <= 100; k++) {
            int cnt = 0;
            initVisited();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && board[i][j] > k) {
                        visited[i][j] = true;
                        cnt++;
                        dfs(i, j, k);
                    }

                }
            }
          //  System.out.println(cnt);

            if (cnt > maxKCnt) {
                maxKCnt = cnt;
                maxK = k;
            }


        }

        System.out.println(maxK + " " + maxKCnt);
    }
}
