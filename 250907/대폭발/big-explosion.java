import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, m, r, c;
    static int[][] arr;
    static int[][] temp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    static void check(int x, int y, int t) {
        int size = (int) Math.pow(2, t - 1);

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k] * size;
            int ny = y + dy[k] * size;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            temp[nx][ny] = 1;


        }


    }


    static void go(int t) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    check(i, j, t);
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp[i][j];

            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[n][n];
        temp = new int[n][n];
        arr[r][c] = 1;

        int t = 1;
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = arr[i][j];
                }
            }

            go(t);


            if (t == m) {
                break;
            }

            t++;


        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {

                    cnt++;

                }
            }
        }

        System.out.println(cnt);
    }
}
