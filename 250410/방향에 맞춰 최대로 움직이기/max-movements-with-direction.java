import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] arrDir;
    static int res = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};


    static void choose(int x, int y, int cnt) {
        res = Math.max(cnt, res);
        int dir = arrDir[x][y];
        for (int k = 1; k < n; k++) {
            int nx = x + dx[dir] * k;
            int ny = y + dy[dir] * k;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[x][y] > arr[nx][ny]) {
                continue;
            }

            choose(nx, ny, cnt + 1);


        }

    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        arrDir = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrDir[i][j] = sc.nextInt() - 1;
            }
        }

        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;

        choose(startX, startY, 0);
        System.out.println(res);

    }
}
