import java.util.Scanner;

public class Main {
    static final int[] dx = {-1, 0, 0, 1}; // U R L D
    static final int[] dy = {0, 1, -1, 0};
    static final int MAX_ASCII = 128;

    static int t, n, m;
    static int[][] dirArr, nextDirArr, removeArr;
    static final char[] DIR_CHAR = {'U', 'R', 'L', 'D'};
    static final int[] DIR_MAP = new int[MAX_ASCII];

    static {
        DIR_MAP['U'] = 0;
        DIR_MAP['R'] = 1;
        DIR_MAP['L'] = 2;
        DIR_MAP['D'] = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();

            dirArr = new int[n][n];
            nextDirArr = new int[n][n];
            removeArr = new int[n][n];

            initArray(dirArr, -1);

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                char d = sc.next().charAt(0);
                dirArr[x][y] = DIR_MAP[d];
            }

            simulate();

            System.out.println(countRemaining());
        }
    }

    static void simulate() {
        int time = 2 * n;

        while (time-- > 0) {
            initArray(nextDirArr, -1);
            initArray(removeArr, 0);

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dirArr[i][j] >= 0)
                        move(i, j);

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (removeArr[i][j] > 1)
                        nextDirArr[i][j] = -1;

            copyArray(nextDirArr, dirArr);
        }
    }

    static void move(int x, int y) {
        int dir = dirArr[x][y];
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (!inRange(nx, ny)) {
            nextDirArr[x][y] = 3 - dir;
            removeArr[x][y]++;
        } else {
            nextDirArr[nx][ny] = dir;
            removeArr[nx][ny]++;
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static void initArray(int[][] arr, int val) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = val;
    }

    static void copyArray(int[][] from, int[][] to) {
        for (int i = 0; i < n; i++)
            System.arraycopy(from[i], 0, to[i], 0, n);
    }

    static int countRemaining() {
        int res = 0;
        for (int[] row : dirArr)
            for (int d : row)
                if (d >= 0)
                    res++;
        return res;
    }
}