import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dpMin = new int[n][n];
        int[][] dpMax = new int[n][n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dpMin[0][0] = arr[0][0];
        dpMax[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            dpMin[i][0] = Math.min(dpMin[i - 1][0], arr[i][0]);
            dpMin[0][i] = Math.min(dpMin[0][i - 1], arr[0][i]);

            dpMax[i][0] = Math.max(dpMax[i - 1][0], arr[i][0]);
            dpMax[0][i] = Math.max(dpMax[0][i - 1], arr[0][i]);
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int tmepUpMin = Math.min(dpMin[i - 1][j], arr[i][j]);
                int tmepUpMax = Math.max(dpMax[i - 1][j], arr[i][j]);


                int tempLeftMin = Math.min(dpMin[i][j - 1], arr[i][j]);
                int tempLeftMax = Math.max(dpMax[i][j - 1], arr[i][j]);


                int tempUp = tmepUpMax - tmepUpMin;
                int tempLeft = tempLeftMax - tempLeftMin;

                if (tempLeft < tempUp) {
                    dpMin[i][j] = tempLeftMin;
                    dpMax[i][j] = tempLeftMax;

                } else {
                    dpMin[i][j] = tmepUpMin;
                    dpMax[i][j] = tmepUpMax;

                }


            }
        }
        System.out.println(dpMax[n - 1][n - 1] - dpMin[n - 1][n - 1]);


    }
}
