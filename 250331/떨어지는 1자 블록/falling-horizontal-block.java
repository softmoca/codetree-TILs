import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] nextArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt() - 1;

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int row = 0;
        A:
        while (row < n - 1) {
            for (int col = k; col < k + m; col++) {
                if (arr[row + 1][col] == 1) {
                    break A;
                }
            }
            row++;

        }

        for (int col = k; col < k + m; col++) {
            arr[row][col] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }


}


