import java.util.*;

public class Main {
    static int n, m, c;
    static int[][] board;
    static int maxTotal = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();

        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 <= n - m; j1++) {
                int max1 = getMaxHoney(i1, j1);

                for (int i2 = i1; i2 < n; i2++) {
                    int startJ = (i1 == i2) ? j1 + m : 0;

                    for (int j2 = startJ; j2 <= n - m; j2++) {
                        int max2 = getMaxHoney(i2, j2);
                        maxTotal = Math.max(maxTotal, max1 + max2);
                    }
                }
            }
        }

        System.out.println(maxTotal);
    }

    // 해당 위치 (row, col)부터 m개의 칸 중 조건을 만족하는 최대 제곱합 구하기
    static int getMaxHoney(int row, int col) {
        int[] segment = new int[m];
        for (int i = 0; i < m; i++) {
            segment[i] = board[row][col + i];
        }

        return getBestSubsetScore(segment);
    }

    // c 이하로 꿀을 채취하는 모든 부분집합의 제곱합 중 최대값
    static int getBestSubsetScore(int[] segment) {
        int maxScore = 0;
        int len = segment.length;

        for (int bit = 1; bit < (1 << len); bit++) {
            int sum = 0;
            int score = 0;

            for (int i = 0; i < len; i++) {
                if ((bit & (1 << i)) > 0) {
                    sum += segment[i];
                    score += segment[i] * segment[i];
                }
            }

            if (sum <= c) {
                maxScore = Math.max(maxScore, score);
            }
        }

        return maxScore;
    }
}
