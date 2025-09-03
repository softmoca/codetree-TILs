import java.io.*;
import java.util.*;

/*

 */


public class Main {

    static int count(int x, int y, int[][] arr) {

        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[x + i][y + j] == 1) cnt++;
            }
        }


        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {

                res = Math.max(res, count(i, j, arr));

            }
        }

        System.out.println(res);


    }
}
