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
    static int r1, r2, c1, c2;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static int res = Integer.MAX_VALUE;
    static List<Pair> walls;
    static List<Integer> answer = new ArrayList<>();

    static boolean canGo(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && arr[x][y] == 0) return true;
        return false;
    }

    static void bfs() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        ArrayDeque<Pair> qu = new ArrayDeque<>();
        visited[r1][c1] = true;
        qu.offer(new Pair(r1, c1));

        while (!qu.isEmpty()) {
            Pair pair = qu.poll();
            int x = pair.x;
            int y = pair.y;

            for (int w = 0; w < 4; w++) {
                int nx = x + dx[w];
                int ny = y + dy[w];

                if (canGo(nx, ny)) {

                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    qu.offer(new Pair(nx, ny));
                    if (nx == r2 && ny == c2) {
                        res = Math.min(res, dist[nx][ny]);
                    }

                }

            }


        }


    }

    static void dfs(int currIdx, int startIdx) {
        if (currIdx == k) {

            // 1. 벽 제거하기
            for (int i = 0; i < answer.size(); i++) {
                Pair pair = walls.get(answer.get(i));
                arr[pair.x][pair.y] = 0;
            }


            // 2. 최소값 계산
            visited = new boolean[n][n];
            dist = new int[n][n];

            bfs();


            //3. 벽 복구
            for (int i = 0; i < answer.size(); i++) {
                Pair pair = walls.get(answer.get(i));
                arr[pair.x][pair.y] = 1;
            }

            return;
        }


        for (int i = startIdx; i < walls.size(); i++) {
            answer.add(i);
            dfs(currIdx + 1, i + 1);
            answer.remove(answer.size() - 1);

        }


    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][n];
        walls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    walls.add(new Pair(i, j));
                }

            }
        }

        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        r1--;
        r2--;
        c1--;
        c2--;


        dfs(0, 0);
        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }

    }
}
