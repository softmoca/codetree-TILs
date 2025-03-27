import java.util.Scanner;

public class Main {
    static int n;
    static int[][] grid;
    static int[][] nextGrid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int t = sc.nextInt();

        grid = new int[n][n];
        nextGrid = new int[n][n];

        // 입력
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                grid[row][col] = sc.nextInt();

        while (t-- > 0) {
            int targetCol = sc.nextInt() - 1;
            int targetRow = findFirstNonZeroRow(targetCol);

            if (targetRow == -1)
                break;

            int bombRange = grid[targetRow][targetCol] - 1;
            grid[targetRow][targetCol] = 0;

            // 4방향 폭파
            explodeInDirection(targetRow, targetCol, -1, 0, bombRange); // 위
            explodeInDirection(targetRow, targetCol, 1, 0, bombRange);  // 아래
            explodeInDirection(targetRow, targetCol, 0, -1, bombRange); // 왼쪽
            explodeInDirection(targetRow, targetCol, 0, 1, bombRange);  // 오른쪽

            // 중력 적용
            applyGravity();
        }

        // 출력
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    static int findFirstNonZeroRow(int col) {
        for (int row = 0; row < n; row++) {
            if (grid[row][col] != 0)
                return row;
        }
        return -1;
    }

    static void explodeInDirection(int row, int col, int dRow, int dCol, int range) {
        for (int i = 0; i < range; i++) {
            row += dRow;
            col += dCol;

            if (row < 0 || row >= n || col < 0 || col >= n)
                break;

            grid[row][col] = 0;
        }
    }

    static void applyGravity() {
        // 초기화
        nextGrid = new int[n][n];

        for (int col = 0; col < n; col++) {
            int writeRow = n - 1;

            for (int row = n - 1; row >= 0; row--) {
                if (grid[row][col] != 0) {
                    nextGrid[writeRow--][col] = grid[row][col];
                }
            }
        }

        // 다시 복사
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                grid[row][col] = nextGrid[row][col];
    }
}