import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> answer = new ArrayList<>();
    static int[][] arr;
    static int[][] temp;
    static int cnt = 0;
    static int n;
    static int res = 0;
    static int[][] dx = {
            {1, 2, -1, -2},
            {-1, 0, 1, 0},
            {-1, 1, 1, -1}
    };

    static int[][] dy = {
            {0, 0, 0, 0},
            {0, 1, 0, -1},
            {1, 1, -1, -1}
    };


    static void check(int x, int y, int type) {
        temp[x][y] = 1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[type - 1][k];
            int ny = y + dy[type - 1][k];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            temp[nx][ny] = 1;
        }

    }

    static void count() {

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    check(i, j, answer.get(idx++));
                }

            }
        }
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 1) {
                    sum++;
                }

            }
        }

        //디버깅
//        System.out.println("answer");
//        for (int i = 0; i < answer.size(); i++) {
//            System.out.print(answer.get(i) + " ");
//        }
//        System.out.println();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(temp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        res = Math.max(res, sum);


    }


    static void c(int currIdx) {

        if (currIdx == cnt + 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = 0;
                }
            }

            count();

            return;
        }

        for (int i = 1; i <= 3; i++) {
            answer.add(i);
            c(currIdx + 1);
            answer.remove(answer.size() - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                }
            }
        }

        c(1);
        System.out.println(res);

    }
}
