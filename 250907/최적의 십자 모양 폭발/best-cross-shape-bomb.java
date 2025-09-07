import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n;
    static int[][] arr;
    static int[][] temp;

    static void boom(int x, int y) {
        int size = arr[x][y];
        arr[x][y] = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int startx = x;
        int starty = y;

        for (int k = 0; k < 4; k++) {
            x = startx;
            y = starty;
            for (int s = 1; s < size; s++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;

                arr[nx][ny] = 0;
                x = nx;
                y = ny;

            }

        }

    }

    static void gravity(int col) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i][col] == 0) continue;
            dq.addLast(arr[i][col]);
        }

        int dqsize = dq.size();
        for (int i = 0; i < n - dqsize; i++) {
            dq.addLast(0);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i][col] = dq.removeFirst();
        }

    }


    static void go(int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp[i][j];
            }
        }

        boom(x, y);

        for (int i = 0; i < n; i++) {
            gravity(i);
        }


        int cnt = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (arr[nx][ny] == arr[i][j]) cnt++;
                }

            }
        }


        res = Math.max(res, cnt / 2);
  //      System.out.println(res);


    }

    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                temp[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                go(i, j);
            }
        }
        System.out.println(res);

    }
}
