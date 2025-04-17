import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        maxDp[0][0] = minDp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            maxDp[0][i] = Math.max(arr[0][i], maxDp[0][i - 1]);
            maxDp[i][0] = Math.max(arr[i][0], maxDp[i - 1][0]);
        }
        for (int i = 1; i < n; i++) {
            minDp[0][i] = Math.min(arr[0][i], minDp[0][i - 1]);
            minDp[i][0] = Math.min(arr[i][0], minDp[i - 1][0]);
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(minDp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(maxDp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {


                //아래
                int downMax = Math.max(arr[i][j], maxDp[i - 1][j]);
                int downMin = Math.min(arr[i][j], minDp[i - 1][j]);

                int down = downMax - downMin;


                //오른쪽
                int rightMax = Math.max(arr[i][j], maxDp[i][j - 1]);
                int rightMin = Math.min(arr[i][j], minDp[i][j - 1]);

                int right = rightMax - rightMin;

                if (right > down) {//down 값이 들어가야함.
                    maxDp[i][j] = downMax;
                    minDp[i][j] = downMin;
                } else {
                    maxDp[i][j] = rightMax;
                    minDp[i][j] = rightMin;
                }

            }
        }

        System.out.println(maxDp[n - 1][n - 1] - minDp[n - 1][n - 1]);


    }
}
