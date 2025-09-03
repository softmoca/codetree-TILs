import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int count1(int x, int y, int[][] arr) {
        int sum = 0;
        sum += arr[x][y];
        sum += arr[x + 1][y];
        sum += arr[x + 1][y + 1];
        return sum;
    }

    static int count2(int x, int y, int[][] arr) {
        int sum = 0;
        sum += arr[x][y];
        sum += arr[x + 1][y];
        sum += arr[x][y + 1];
        return sum;
    }

    static int count3(int x, int y, int[][] arr) {
        int sum = 0;
        sum += arr[x][y];
        sum += arr[x][y + 1];
        sum += arr[x + 1][y + 1];
        return sum;
    }

    static int count4(int x, int y, int[][] arr) {
        int sum = 0;
        sum += arr[x + 1][y];
        sum += arr[x][y + 1];
        sum += arr[x + 1][y + 1];
        return sum;
    }

    static int count5(int x, int y, int[][] arr) {
        int sum = 0;
        sum += arr[x][y];
        sum += arr[x + 1][y];
        sum += arr[x + 2][y];
        return sum;
    }

    static int count6(int x, int y, int[][] arr) {
        int sum = 0;
        sum += arr[x][y];
        sum += arr[x][y + 1];
        sum += arr[x][y + 2];
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                res = Math.max(res, count1(i, j, arr));
                res = Math.max(res, count2(i, j, arr));
                res = Math.max(res, count3(i, j, arr));
                res = Math.max(res, count4(i, j, arr));
            }
        }

        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m ; j++) {
                res = Math.max(res, count5(i, j, arr));
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m-2; j++) {
                res = Math.max(res, count6(i, j, arr));
            }
        }
        System.out.println(res);

    }
}
