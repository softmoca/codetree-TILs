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
    static int k;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static ArrayDeque<Pair> qu = new ArrayDeque<>();

    static void push(int x, int y, int nextDist) {
        qu.offer(new Pair(x, y));
        visited[x][y] = true;
        dist[x][y] = nextDist;
    }

    static boolean canGo(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && arr[x][y] == 1) return true;
        return false;

    }

    static void bfs() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        while (!qu.isEmpty()) {
            Pair pair = qu.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canGo(nx, ny)) {
                    push(nx, ny, dist[x][y] + 1);

                }

            }


        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) {
                    push(i, j, 0);
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 2) {
                    System.out.print(0 + " ");
                } else if (arr[i][j] == 0) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }


            }
            System.out.println();
        }


    }
}
