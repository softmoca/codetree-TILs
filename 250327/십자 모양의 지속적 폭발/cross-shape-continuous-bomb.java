import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int t = sc.nextInt();

        arr = new int[n][n];
        temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }

        }

        while (t-- > 0) {
            int startCol = sc.nextInt() - 1;
            int startRow = -1;
            // temp 초기화
            temp = new int[n][n];

            // 시작 행 찾기
            for (int i = 0; i < n; i++) {
                if (arr[i][startCol] != 0) {
                    startRow = i;
                    break;
                }
            }

            if (startRow == -1) {
                continue;
            }
            int boomSize = arr[startRow][startCol] - 1;
            // 폭탄 범위 0으로 만들기

            arr[startRow][startCol] = 0;
            int x = startRow;
            int y = startCol;
            for (int i = 0; i < boomSize; i++) {// 위쪽
                if (x - 1 >= 0) {
                    arr[--x][startCol] = 0;
                } else {
                    break;
                }
            }

            x = startRow;
            y = startCol;

            for (int i = 0; i < boomSize; i++) {// 오른쪽
                if (y + 1 < n) {
                    arr[startRow][++y] = 0;
                } else {
                    break;
                }
            }

            x = startRow;
            y = startCol;
            for (int i = 0; i < boomSize; i++) {// 아래
                if (x + 1 < n) {
                    arr[++x][startCol] = 0;
                } else {
                    break;
                }
            }

            x = startRow;
            y = startCol;
            for (int i = 0; i < boomSize; i++) {// 왼쪽
                if (y - 1 >= 0) {
                    arr[startRow][--y] = 0;
                } else {
                    break;
                }
            }

            //중력 적용

            for (int col = 0; col < n; col++) {
                int nextRow = n - 1;
                int tempIdx = 0;
                for (int row = 0; row < n; row++) {
                    if (arr[nextRow - row][col] != 0) {
                        temp[nextRow - tempIdx++][col] = arr[nextRow - row][col];
                    }
                }
            }

            //다시 옮기기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = temp[i][j];
                }
            }


        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
}
