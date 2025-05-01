import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    static boolean canGo(int x, int y) {


        if (x < 0 || y < 0 || x >= n || y >= m) return false;
        if (visited[x][y]) return false;
        if (arr[x][y] == 0) return false;
        return true;
    }

    static void bfs() {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        ArrayDeque<Pair> qu = new ArrayDeque<>();
        qu.addLast(new Pair(0, 0));
        visited[0][0] = true;

        while (!qu.isEmpty()) {

            Pair curr = qu.removeFirst();
            int x = curr.x;
            int y = curr.y;


            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (canGo(nx, ny)) {

                    visited[nx][ny] = true;
                    qu.addLast(new Pair(nx, ny));

                }


            }


        }


    }

    static boolean[][] visited;
    static int[][] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        visited = new boolean[n][m];
        bfs();

        if (visited[n - 1][m - 1]) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }
}
