import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] temp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int q = sc.nextInt();

        int[][] arr = new int[n][m];
        temp = new int[n][m];
        initArray(sc, arr);

        while (q-- > 0) {
            int startx = sc.nextInt() - 1;
            int starty = sc.nextInt() - 1;
            int endx = sc.nextInt() - 1;
            int endy = sc.nextInt() - 1;

            rotateBorder(arr, startx, starty, endx, endy);
            applyAverageSmoothing(arr, startx, starty, endx, endy);
        }

        printArray(arr);
    }

    static void initArray(Scanner sc, int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }

    static void rotateBorder(int[][] arr, int startx, int starty, int endx, int endy) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= endy - starty; i++) deque.addLast(arr[startx][starty + i]);
        for (int i = 0; i < endx - startx - 1; i++) deque.addLast(arr[startx + 1 + i][endy]);
        for (int i = 0; i <= endy - starty; i++) deque.addLast(arr[endx][endy - i]);
        for (int i = 0; i < endx - startx - 1; i++) deque.addLast(arr[endx - 1 - i][starty]);

        deque.addFirst(deque.removeLast());

        for (int i = 0; i <= endy - starty; i++) arr[startx][starty + i] = deque.removeFirst();
        for (int i = 0; i < endx - startx - 1; i++) arr[startx + 1 + i][endy] = deque.removeFirst();
        for (int i = 0; i <= endy - starty; i++) arr[endx][endy - i] = deque.removeFirst();
        for (int i = 0; i < endx - startx - 1; i++) arr[endx - 1 - i][starty] = deque.removeFirst();
    }

    static void applyAverageSmoothing(int[][] arr, int startx, int starty, int endx, int endy) {
        for (int i = startx; i <= endx; i++) {
            for (int j = starty; j <= endy; j++) {
                smoothCell(i, j, arr);
            }
        }

        for (int i = startx; i <= endx; i++) {
            for (int j = starty; j <= endy; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }

    static void smoothCell(int x, int y, int[][] arr) {
        int cnt = 1;
        int sum = arr[x][y];

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                cnt++;
                sum += arr[nx][ny];
            }
        }

        temp[x][y] = sum / cnt;
    }

    static void printArray(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
