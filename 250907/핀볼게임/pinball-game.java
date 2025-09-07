import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n;
    static int[][] arr;
    static int res = 0;
    static int[] dx = {-1, 0, 1, 0};


    static void cal(int x, int y, int dir) {
        int time = 0;

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
            x = nx;
            y = ny;


            if (dir == 0) {
                if (arr[x][y] == 1) {
                    dir = 1;


                } else if (arr[x][y] == 2) {
                    dir = 3;
                }

            } else if (dir == 1) {

                if (arr[x][y] == 1) {
                    dir = 0;


                } else if (arr[x][y] == 2) {
                    dir = 2;
                }
            } else if (dir == 2) {
                if (arr[x][y] == 1) {
                    dir = 3;


                } else if (arr[x][y] == 2) {
                    dir = 1;
                }
            } else if (dir == 3) {
                if (arr[x][y] == 1) {
                    dir = 2;


                } else if (arr[x][y] == 2) {
                    dir = 0;
                }
            }


        }

        //  System.out.println(time);
        res = Math.max(res, time);
    }

    static void goUpDown(int col, int dir) {

        if (dir == 0) { // 위쪾
            int x = n;
            int y = col;
            cal(x, y, dir);
        } else {// 아래쪾
            int x = -1;
            int y = col;
            cal(x, y, dir);
        }


    }

    static void goRL(int row, int dir) {
        if (dir == 1) { // 오른쪽
            int x = row;
            int y = -1;
            cal(x, y, dir);
        } else {// 왼쪽
            int x = row;
            int y = n;
            cal(x, y, dir);
        }

    }

    static int[] dy = {0, 1, 0, -1};

    static void go(int num, int dir) {
        if (dir == 0 || dir == 2) {
            goUpDown(num, dir);
        } else {
            goRL(num, dir);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < n; i++) {
                go(i, k);

            }


        }
        System.out.println(res);


    }
}
