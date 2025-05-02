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
    static int r1;
    static int c1;
    static int r2;
    static int c2;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dist;

    static boolean canGo(int x, int y) {
        if (x >= 0 && x < n && y < n && y >= 0 && !visited[x][y]) return true;
        return false;
    }

    static void bfs() {

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        visited[r1][c1] = true;
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(r1, c1));


        while (!qu.isEmpty()) {
            Pair currPair = qu.poll();
            int x = currPair.x;
            int y = currPair.y;

            for (int k = 0; k < 8; k++) {
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
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        r1--;
        c1--;
        r2--;
        c2--;

        arr = new int[n][n];
        dist = new int[n][n];
        visited = new boolean[n][n];


        bfs();

        if (dist[r2][c2] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dist[r2][c2]);
        }


    }
}
