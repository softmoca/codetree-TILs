import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static int[][] board;
    static boolean[][] visited;
    static int cnt = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int totalCnt = 0;
    static int maxCnt = 0;

    static void dfs(int x, int y, int h) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && board[nx][ny] == h) {
                visited[nx][ny] = true;
                //   System.out.println("ddd" + nx + " " + ny);
                cnt++;
                dfs(nx, ny, h);
            }


        }


    }

    static void initVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int k = 1; k <= 100; k++) {
            initVisited();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] == k) {
                        visited[i][j] = true;
                        cnt = 1;

                        dfs(i, j, k);
                        if (cnt >= 4) {
                            totalCnt++;
                        }
                        if (cnt > maxCnt) {
                            maxCnt = cnt;

                        }


                    }

                }
            }


        }

        System.out.println(totalCnt + " " + maxCnt);
    }
}
