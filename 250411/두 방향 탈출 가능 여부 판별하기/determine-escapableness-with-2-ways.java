import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static boolean flag = false;

    static void dfs(int x, int y) {

        if (x == n - 1 && y == m - 1) {
            System.out.println(1);
            System.exit(0);
        }

        for (int k = 0; k < 2; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < n && ny < m && board[nx][ny] == 1) {
                dfs(nx, ny);
            }


        }
      

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
        System.out.println(0);


    }
}
