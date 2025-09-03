import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int res = 0;

    static void countBfs(int x, int y, int[][] arr, int money) {

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[x][y] = true;
        int maxK = arr.length + 1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int sizeK = 0;
        int cnt = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (arr[curr[0]][curr[1]] == 1) cnt++;

                for (int k = 0; k < 4; k++) {
                    int newX = curr[0] + dx[k];
                    int newY = curr[1] + dy[k];

                    if (newX < 0 || newX >= arr.length || newY < 0 || newY >= arr.length) continue;
                    if (visited[newX][newY]) continue;
                    q.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;

                }


            }

            int temp = sizeK * sizeK + (sizeK + 1) * (sizeK + 1);
            int temp2 = cnt * money;
            if (temp <= temp2) {
                res = Math.max(res, cnt);
            }


            sizeK++;

            if (sizeK == maxK) return;

        }


    }


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                countBfs(i, j, arr, money);
            }
        }
        System.out.println(res);


    }
}
