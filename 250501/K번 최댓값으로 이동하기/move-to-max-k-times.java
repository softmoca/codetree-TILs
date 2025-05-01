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

    static boolean canGo(int x, int y, int target) {


        if (x < 0 || y < 0 || x >= n || y >= n) return false;
        if (visited[x][y]) return false;
        if (arr[x][y] >= target) return false;
        return true;
    }

    static Pair bfs(int startX, int startY) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        qu.add(new Pair(startX, startY));
        visited[startX][startY] = true;
        int res = -1;

        while (!qu.isEmpty()) {

            Pair curr = qu.removeFirst();
            int x = curr.x;
            int y = curr.y;


            for (int w = 0; w < 4; w++) {
                int nx = x + dx[w];
                int ny = y + dy[w];

                if (canGo(nx, ny, arr[startX][startY])) {
                    res = Math.max(res, arr[nx][ny]);

                    visited[nx][ny] = true;
                    qu.addLast(new Pair(nx, ny));

                }


            }


        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == res) return new Pair(i, j);
            }
        }

        return new Pair(startX, startY);
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


        int x = sc.nextInt();
        int y = sc.nextInt();
        x--;
        y--;
        Pair next;
        k--;
        do {
            //    System.out.println(x + " " + y);
            next = bfs(x, y);
            visited = new boolean[n][n];
            x = next.x;
            y = next.y;


        } while (k-- > 0);


        System.out.println((next.x + 1) + " " + (next.y + 1));


    }
}
