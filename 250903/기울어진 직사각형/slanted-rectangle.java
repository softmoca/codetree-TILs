import java.io.*;
import java.util.*;

/*

 */


public class Main {

    static int res = 0;

    static void check(int x, int y, int cnt1, int cnt2, int n, int[][] arr) {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1};
        int sum = 0;

        int nx = -1;
        int ny = -1;
        for (int i = 0; i < cnt1; i++) {
            nx = x + dx[0];
            ny = y + dy[0];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) return;
            x = nx;
            y = ny;
            sum += arr[x][y];

        }

        for (int i = 0; i < cnt2; i++) {
            nx = x + dx[1];
            ny = y + dy[1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) return;
            x = nx;
            y = ny;
            sum += arr[x][y];
        }

        for (int i = 0; i < cnt1; i++) {
            nx = x + dx[2];
            ny = y + dy[2];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) return;
            x = nx;
            y = ny;
            sum += arr[x][y];
        }

        for (int i = 0; i < cnt2; i++) {
            nx = x + dx[3];
            ny = y + dy[3];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) return;
            x = nx;
            y = ny;
            sum += arr[x][y];
        }

res=Math.max(res,sum);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 2; k < n; k++) {
                    for (int num1 = 1; num1 < k; num1++) {
                        //          System.out.println(num1 + " " + (k - num1));
                        check(i, j, num1, k - num1, n, arr);
                    }


                }


            }
        }
        System.out.println(res);

    }
}
