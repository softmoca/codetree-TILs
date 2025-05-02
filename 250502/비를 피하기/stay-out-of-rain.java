import java.io.*;
import java.lang.reflect.Parameter;
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
    static int h;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static Pair[] persons;

    static boolean canGo(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && arr[x][y] != 1) {
            return true;
        }
        return false;

    }

    static int bfs(Pair pair) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        ArrayDeque<Pair> qu = new ArrayDeque<>();
        qu.offer(pair);


        visited[pair.x][pair.y] = true;

        while (!qu.isEmpty()) {
            Pair currPair = qu.poll();
            int x = currPair.x;
            int y = currPair.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    if (arr[nx][ny] == 3) {
                        return dist[nx][ny];
                    }

                    qu.offer(new Pair(nx, ny));
                }

            }


        }

        return -1;

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        persons = new Pair[h];
        int[][] answer = new int[n][n];
        int personIdx = 0;
        arr = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) {
                    persons[personIdx++] = new Pair(i, j);
                }
            }
        }


        for (int i = 0; i < h; i++) {
            visited = new boolean[n][n];
            dist = new int[n][n];
            int res = bfs(persons[i]);
            answer[persons[i].x][persons[i].y] = res;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }


    }
}
