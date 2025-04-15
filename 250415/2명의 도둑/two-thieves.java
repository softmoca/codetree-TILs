import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int c;
    static int[][] board;
    static List<Integer> answer = new ArrayList<>();
    static List<Integer> answerM = new ArrayList<>();
    static int MaxRes = 0;
    static int tempScoreMax = Integer.MIN_VALUE;

    static void chooseM(int currIdx, int startIdx, int cnt, int row, int startCol) {

        if (currIdx == cnt) {
            int sum = 0;
            int totoalScore = 0;

            for (int i = 0; i < answerM.size(); i++) {
                if (startCol + answerM.get(i) >= n) return;
                totoalScore = totoalScore + board[row][answerM.get(i) + startCol] * board[row][answerM.get(i) + startCol];
                sum += board[row][answerM.get(i) + startCol];
            }
            if (sum > c) return;

            tempScoreMax = Math.max(tempScoreMax, totoalScore);


            return;

        }

        for (int i = startIdx; i < m; i++) {
            answerM.add(i);
            chooseM(currIdx + 1, i + 1, cnt, row, startCol);
            answerM.remove(answerM.size() - 1);
        }


    }

    static int cal(int row) {
        tempScoreMax = Integer.MIN_VALUE;
        for (int startCol = 0; startCol <= n - m; startCol++) {
            for (int i = 1; i <= m; i++) {
                answerM = new ArrayList<>();
                chooseM(0, 0, i, row, startCol);

            }

        }

        return tempScoreMax;

    }

    static void choose1(int currIdx, int startIdx) {

        if (currIdx == 2) {
            tempScoreMax = Integer.MIN_VALUE;
            int maxScore1 = cal(answer.get(0));
            int maxScore2 = cal(answer.get(1));

            MaxRes = Math.max(MaxRes, maxScore1 + maxScore2);
            return;
        }

        for (int i = startIdx; i < n; i++) {
            answer.add(i);
            choose1(currIdx + 1, i + 1);
            answer.remove(answer.size() - 1);

        }


    }

    static boolean[] visited;

    static boolean isOk(int col1, int col2) {

        for (int i = col1; i < col1 + m; i++) {
            if (i >= n) return false;
            visited[i] = true;
        }

        for (int i = col2; i < col2 + m; i++) {
            if (i >= n) return false;
            if (visited[i]) return false;
        }

        return true;
    }

    static int cal2(int row, int startCol) {
        tempScoreMax = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            answerM = new ArrayList<>();
            chooseM(0, 0, i, row, startCol);
            answerM = new ArrayList<>();
        }


        return tempScoreMax;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }


        //1. 서로 다른 두곳
        choose1(0, 0);
     //   System.out.println(MaxRes);

        //2. 같은 행 선택
        for (int row = 0; row < n; row++) {

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    visited = new boolean[n];
                    if (isOk(i, j)) {
                        int tempMax1 = cal2(row, i);
                        int tempMax2 = cal2(row, j);
                       // System.out.println(row + " " + tempMax1 + " " + tempMax2);
                     //   System.out.println(i + " " + j);
                        MaxRes = Math.max(MaxRes, tempMax1 + tempMax2);
                   //     System.out.println();
                    }
                }
            }


        }

        System.out.println(MaxRes);
    }
}
