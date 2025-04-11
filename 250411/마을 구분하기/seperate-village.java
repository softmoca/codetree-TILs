import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int totalCnt = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 1;

    static void dfs(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 1 && !visited[nx][ny]) {
                cnt++;
                visited[nx][ny]=true;
                dfs(nx, ny);
            }


        }


    }

    static List<Integer> cntList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    visited[i][j]=true;
                    dfs(i, j);
                    cntList.add(cnt);
                    cnt = 1;

                }


            }
        }

        System.out.println(cntList.size());
        cntList.sort(
                Comparator.comparing((x) -> x)
        );
        for (int x : cntList) {
            System.out.println(x);
        }


    }
}
