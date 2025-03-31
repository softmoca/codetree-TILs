import java.util.Scanner;


public class Main {
    static int n;
    static int arr[][];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static int res = 0;

    static void go(int currX, int currY, int dir) {
        int cnt = 1;
        while (true) {

            int nx = currX + dx[dir];
            int ny = currY + dy[dir];
            cnt++;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                res = Math.max(res, cnt);
                return;
            }

            currX = nx;
            currY = ny;

            if (arr[currX][currY] == 1) {
                if (dir % 2 == 0) {//
                    dir = (dir + 1) % 4;
                } else {
                    dir = (dir - 1 + 4) % 4;
                }

            } else if (arr[currX][currY] == 2) {
                if (dir % 2 == 0) {//
                    dir = (dir - 1 + 4) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }

            }


        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

            }
        }

        int dir = 0; //동
        for (int row = 0; row < n; row++) {
            if (arr[row][0] == 1) {
                dir = (dir + 1) % 4;
            } else if (arr[row][0] == 2) {
                dir = (dir - 1 + 4) % 4;
            }
            go(row, 0, dir);
        }

        dir = 1; //북
        for (int col = 0; col < n; col++) {
            if (arr[n - 1][col] == 1) {
                dir = (dir + 1) % 4;
            } else if (arr[n - 1][col] == 2) {
                dir = (dir - 1 + 4) % 4;
            }
            go(n - 1, col, dir);
        }

        dir = 2; //서
        for (int row = 0; row < n; row++) {
            if (arr[row][n - 1] == 1) {
                dir = (dir + 1) % 4;
            } else if (arr[row][n - 1] == 2) {
                dir = (dir - 1 + 4) % 4;
            }
            go(row, n - 1, dir);
        }

        dir = 3; //남
        for (int col = 0; col < n; col++) {
            if (arr[0][col] == 1) {
                dir = (dir + 1) % 4;
            } else if (arr[0][col] == 2) {
                dir = (dir - 1 + 4) % 4;
            }
            go(0, col, dir);
        }
        System.out.println(res);


    }
}
