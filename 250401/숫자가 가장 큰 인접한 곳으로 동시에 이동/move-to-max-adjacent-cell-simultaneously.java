import java.util.Scanner;


public class Main {
    static int n;
    static int m; //구슬의 개수
    static int t;
    static int arr[][];
    static int count[][];
    static int nextCount[][];
    static int[] dx = {1, -1, 0, 0};//상하좌우
    static int[] dy = {0, 0, -1, 1};

    static void checkNext(int row, int col) {

        int maxValue = Integer.MIN_VALUE;
        int maxK = -1;
        for (int k = 0; k < 4; k++) {
            int nx = row + dx[k];
            int ny = col + dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] > maxValue) {
                maxK = k;
                maxValue = arr[nx][ny];
            }

        }

        if (maxK != -1) {
            int nx = row + dx[maxK];
            int ny = col + dy[maxK];
            nextCount[nx][ny]++;
        }


    }

    static void simulate() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextCount[i][j] = 0;
            }
        }
        // 구슬 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 1) {
                    checkNext(i, j);
                }
            }
        }

        // 디버깅
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(count[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(nextCount[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 중복된 구슬 삭제
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nextCount[i][j] > 1) {
                    nextCount[i][j] = 0;
                }
            }
        }

        //원래 count로 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[i][j] = nextCount[i][j];
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt(); //구슬의 개수
        t = sc.nextInt();
        arr = new int[n][n];
        count = new int[n][n];
        nextCount = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            count[row][col] = 1;
        }

        while (t-- > 0) {
            // System.out.println("Ddd");
            simulate();
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 1) {
                    res++;

                }
            }
        }
        System.out.println(res);


    }
}
