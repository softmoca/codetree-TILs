import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static class Pair {
        int col, row;

        Pair(int col, int row) {
            this.col = col;
            this.row = row;
        }

    }

    static int n;
    static int m;
    static Pair[] pairs;
    static int[][] arrTemp;
    static int[] ansTemp;
    static List<Pair> answer = new ArrayList<>();
    static int res = Integer.MAX_VALUE;
    static int[] ans;

    static void init() {

        for (int i = 0; i < m + 2; i++) {
            for (int j = 0; j < n * 2; j++) {
                arrTemp[i][j] = 0;
            }
        }

        for (int i = 1; i < 2 * n; i += 2) {
            arrTemp[0][i] = i;
        }

        for (int i = 0; i < 2 * n; i++) {
            ansTemp[i] = 0;
        }


    }

    static void draw() {
        for (int i = 0; i < answer.size(); i++) {
            int col = answer.get(i).col;
            int row = answer.get(i).row;
            col = col * 2 - 1;
            arrTemp[row][col + 1] = -1;
        }


    }

    static void makeAnsTemp() {
        for (int col = 1; col < 2 * n; col += 2) {
            int tempCol = col;
            for (int row = 0; row < m; row++) {
                if (tempCol - 1 != 0 && arrTemp[row + 1][tempCol - 1] == -1) {
                    tempCol -= 2;
                } else if (tempCol + 1 != 2 * n && arrTemp[row + 1][tempCol + 1] == -1) {
                    tempCol += 2;
                }
            }
            ansTemp[tempCol] = col;
        }

    }

    static boolean ok() {
        for (int i = 0; i < 2 * n; i++) {
            if (ans[i] != ansTemp[i]) {
                return false;
            }
        }

        return true;
    }


    static void choose(int currIdx) {
        if (currIdx == m) {

            init();

            draw();
            makeAnsTemp();

            if (ok()) {
                res = Math.min(res, answer.size());
            }

            return;
        }

        answer.add(pairs[currIdx]);
        choose(currIdx + 1);
        answer.remove(answer.size() - 1);
        choose(currIdx + 1);


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] arr = new int[m + 2][n * 2];
        arrTemp = new int[m + 2][n * 2];
        for (int i = 1; i < 2 * n; i += 2) {
            arr[0][i] = i;
        }
        pairs = new Pair[m];

        for (int i = 0; i < m; i++) {
            int col = sc.nextInt();
            int row = sc.nextInt();
            pairs[i] = new Pair(col, row);
            col = col * 2 - 1;
            arr[row][col + 1] = -1;
        }

//        for (int i = 0; i < 2 * n; i++) {
//            for (int j = 0; j < m + 2; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        ans = new int[2 * n];
        ansTemp = new int[2 * n];

        for (int col = 1; col < 2 * n; col += 2) {
            int tempCol = col;
            for (int row = 0; row < m; row++) {
                if (tempCol - 1 != 0 && arr[row + 1][tempCol - 1] == -1) {
                    tempCol -= 2;
                } else if (tempCol + 1 != 2 * n && arr[row + 1][tempCol + 1] == -1) {
                    tempCol += 2;
                }
            }
            ans[tempCol] = col;
        }

        // 조합 시작

        choose(0);
        System.out.println(res);

    }
}
