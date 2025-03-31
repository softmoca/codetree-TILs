import java.util.Scanner;


public class Main {
    static int n;
    static int m;
    static boolean[][] arr;
    static boolean[][] nextArr;

    static void setBoom(int x, int y, int size) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k] * (int) Math.pow(2, size);
            int ny = y + dy[k] * (int) Math.pow(2, size);

            if (nx >= 0 && nx < n && ny < n && ny >= 0) {
                nextArr[nx][ny] = true;
            }

        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;

        arr = new boolean[n][n];
        nextArr = new boolean[n][n];

        int time = 0;

        arr[startX][startY] = true;
        nextArr[startX][startY] = true;

        while (time < m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j]) {
                        setBoom(i, j, time);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = nextArr[i][j];
                }
            }

            time++;

        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i][j]) {
                //    System.out.println(i + " " + j);
                    res++;
                }
            }
        }
        System.out.println(res);


    }
}
