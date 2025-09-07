import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void go(int x, int y) {
        System.out.print(arr[x][y] + " ");


        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (arr[x][y] < arr[nx][ny]) {
                go(nx, ny);
                return;
            }

        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(x, y);


    }
}
