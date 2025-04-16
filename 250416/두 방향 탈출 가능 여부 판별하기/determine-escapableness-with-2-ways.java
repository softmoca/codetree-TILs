import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visted;


    static void dfs(int x, int y) {
        visted[x][y] = true;
        if (x == n - 1 && y == m - 1) {
            System.out.println(1);
            System.exit(0);
        }


        int[] dx = {0, 1};
        int[] dy = {1, 0};

        for (int k = 0; k < 2; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < n && ny < m && !visted[nx][ny] && board[nx][ny] == 1) {
                dfs(nx, ny);
            }


        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visted = new boolean[n][m];

        dfs(0, 0);
        System.out.println(0);

    }
}
