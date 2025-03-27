import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int[][] nextArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n][n];
        nextArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        while (k-- > 0) {
            // 1. 폭탄 터짐
            clearNextArr();
            explodeAndApplyGravity();
            // 2. 시계 방향 90도 회전
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    nextArr[col][n - 1 - row] = arr[row][col];
                }
            }
            copyToArr();

            // 3. 전체 중력 적용
            applyGravity();
        }

        // 마지막 폭탄 터짐 반복 (k회 이후에도)
        clearNextArr();
        explodeAndApplyGravity();
        // 결과 출력
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 0) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    static void clearNextArr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextArr[i][j] = 0;
            }
        }
    }

    static void copyToArr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = nextArr[i][j];
            }
        }
    }

    static void applyGravity() {
        clearNextArr();
        for (int col = 0; col < n; col++) {
            int nextRow = n - 1;
            for (int row = n - 1; row >= 0; row--) {
                if (arr[row][col] > 0) {
                    nextArr[nextRow--][col] = arr[row][col];
                }
            }
        }
        copyToArr();
    }
    static void explodeAndApplyGravity() {
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int col = 0; col < n; col++) {
                int cnt = 1;
                for (int row = 1; row <= n; row++) {
                    if (row < n && arr[row][col] != 0 && arr[row][col] == arr[row - 1][col]) {
                        cnt++;
                    } else {
                        if (arr[row - 1][col] != 0 && cnt >= m) {
                            flag = true;
                            for (int i = 0; i < cnt; i++) {
                                arr[row - 1 - i][col] = 0;
                            }
                        }
                        cnt = 1;
                    }
                }
            }

            applyGravity();  // 터진 후 중력 적용
        }
    }


}

