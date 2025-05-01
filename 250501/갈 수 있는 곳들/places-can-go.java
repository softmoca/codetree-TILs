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


        if (x < 0 || y < 0 || x >= n || y >= n) return false;
        if (visited[x][y]) return false;
        if (arr[x][y] == 1) return false;
        return true;
    }

    static void bfs() {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!qu.isEmpty()) {

            Pair curr = qu.removeFirst();
            int x = curr.x;
            int y = curr.y;


            for (int w = 0; w < 4; w++) {
                int nx = x + dx[w];
                int ny = y + dy[w];

                if (canGo(nx, ny)) {

                    visited[nx][ny] = true;
                    qu.addLast(new Pair(nx, ny));

                }


            }


        }


    }

    static boolean[][] visited;
    static ArrayDeque<Pair> qu = new ArrayDeque<>();
    static int[][] arr;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        visited = new boolean[n][n];

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            visited[x - 1][y - 1] = true;
            qu.addLast(new Pair(x - 1, y - 1));

        }


        bfs();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) res++;
            }
        }
        System.out.println(res);


    }
}
