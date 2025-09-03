import java.io.*;
import java.util.*;

/*

 */


public class Main {

    static int res = 0;

    static void countRow(int lineNum, int[][] arr, int m) {
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[lineNum][i] == arr[lineNum][i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt >= m) {
                res++;
                return;
            }

        }
        if (cnt >= m) {
            res++;
            return;
        }

    }

    static void countCol(int lineNum, int[][] arr, int m) {
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][lineNum] == arr[i - 1][lineNum]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt >= m) {
                res++;
                return;
            }

        }
        if (cnt >= m) {
            res++;
            return;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            countRow(i, arr, m);
            countCol(i, arr, m);
        }
        System.out.println(res);


    }
}
