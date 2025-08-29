import java.io.*;
import java.util.*;

/*

1. 4뱡항 모두 자신보다 작은개 없는 곳 1저장.

 */


public class Main {

    static class Pair {
        int x, y, num;

        Pair(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean check(int x, int y, int[][] arr, int[][] dp, int n) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (arr[nx][ny] < arr[x][y]) return true;

        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        List<Pair> pairs = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j, arr, dp, n)) {
                    pairs.add(new Pair(i, j, arr[i][j]));
                } else {
                    dp[i][j] = 1;
                }


            }
        }

        pairs.sort(Comparator.comparing((Pair p) -> p.num));


        for (Pair pair : pairs) {
            int x = pair.x;
            int y = pair.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (dp[nx][ny] == 0) continue;
                if (arr[nx][ny] < arr[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], dp[nx][ny] + 1);
                }


            }


        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        System.out.println(res);


    }
}
