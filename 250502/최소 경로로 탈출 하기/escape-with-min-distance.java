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

    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dist;

    static boolean canGo(int x, int y) {
        if (x >= 0 && x < n && y < m && y >= 0 && arr[x][y] == 1 && !visited[x][y]) return true;
        return false;
    }

    static void bfs() {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        visited[0][0] = true;
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(0, 0));

        while (!qu.isEmpty()) {
            Pair currPair = qu.poll();
            int x = currPair.x;
            int y = currPair.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (canGo(nx, ny)) {
                    qu.offer(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                }


            }


        }


    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        bfs();
        if (dist[n - 1][m - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dist[n - 1][m - 1]);
        }


    }
}
