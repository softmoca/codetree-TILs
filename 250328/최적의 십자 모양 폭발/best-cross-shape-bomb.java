import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] nextArr;
    static int[][] temp;
    static int res = 0;

    static void copyArrToTemp() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[i][j];
            }
        }
    }

    static void clearNextArr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextArr[i][j] = 0;
            }
        }
    }

    static void boom(int centerX, int centerY) {
        int size = temp[centerX][centerY];
        temp[centerX][centerY] = 0;

        explode(centerX, centerY, size, -1, 0);
        explode(centerX, centerY, size, 0, 1);
        explode(centerX, centerY, size, 1, 0);
        explode(centerX, centerY, size, 0, -1);


    }

    static void explode(int x, int y, int size, int dx, int dy) {

        for (int i = 1; i < size; i++) {
            int nx = x + dx;
            int ny = y + dy;

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                temp[nx][ny] = 0;
                x = nx;
                y = ny;
            } else {
                break;
            }
        }
    }

    static void gravity() {
        for (int col = 0; col < n; col++) {
            int nextRow = n - 1;
            for (int row = nextRow; row >= 0; row--) {
                if (temp[row][col] > 0) {
                    nextArr[nextRow--][col] = temp[row][col];
                }
            }
        }
    }

    static void count() {
        int sum = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n - 1; col++) {
                if (nextArr[row][col] == 0) {
                    continue;
                }
                if (nextArr[row][col] == nextArr[row][col + 1]) {
                    sum++;
                }
            }
        }

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n - 1; row++) {
                if (nextArr[row][col] == 0) {
                    continue;
                }
                if (nextArr[row][col] == nextArr[row+1][col]) {
                    sum++;
                }
            }
        }

        res = Math.max(res, sum);


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        nextArr = new int[n][n];
        temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyArrToTemp();//arr배열을 temp로 복사
                boom(i, j);// temp배열 내부에서 폭탄터짐
                clearNextArr();
                gravity();//temp배열에서 중력적용한 값을 nextArr()로 이동.
                count();// 연속된 값 계산 후 정답 갱신


            }
        }
        System.out.println(res);


    }


}


