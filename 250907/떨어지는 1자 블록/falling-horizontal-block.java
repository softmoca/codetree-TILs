import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, m, k;
    static int[][] arr;

    static boolean go(int row) {
        for (int col = k; col < k + m; col++) {
            if (arr[row][col] == 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag;
        int row = n - 1;
        for (int i = 1; i < n; i++) {
            if (go(i)) {
                row = i - 1;
                break;
            }
        }


        for (int i = k; i < k + m; i++) {
            arr[row][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
