import java.util.Scanner;


public class Main {
    static int n;
    static int m; //구슬의 개수
    static int arr[][];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static void change(int i, int j) {
        int maxValue = 0;
        int maxK = -1;
        for (int k = 0; k < 8; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < n && ny < n && ny >= 0) {
                if (arr[nx][ny] > maxValue) {
                    maxValue = arr[nx][ny];
                    maxK = k;
                }
            }
        }

        int nx = i + dx[maxK];
        int ny = j + dy[maxK];

        int temp = arr[i][j];
        arr[i][j] = arr[nx][ny];
        arr[nx][ny] = temp;

    }

    static void simulate() {
       A: for (int num = 1; num <= n * n; num++) {
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == num) {
                        change(i, j);
                        continue A;
                        
                    }
                }
            }


        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt(); //턴수
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        while (m-- > 0) {
            simulate();

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
