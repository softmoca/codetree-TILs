import java.io.*;
import java.util.*;

public class Main {

    static boolean isEnd() {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] != 0) return true;
            }
        }
        return false;
    }

    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean canGo(int x, int y) {
        if (x > 0 && y > 0 && x < n - 1 && y < m - 1) {
            if (arr[x + 1][y] == 1 && arr[x][y + 1] == 1 && arr[x - 1][y] == 1 && arr[x][y - 1] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int time = 0;
        int res = 0;
        while (true) {
            res = 0;
            visited = new boolean[n + 2][m + 2];
            //    System.out.println("dd");
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < m + 2; j++) {

                    if (arr[i][j] == 0 && canGo(i, j)) {

                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n + 2 && ny < n + 2) {
                                if (arr[nx][ny] == 1) {
                                    visited[nx][ny] = true;
                                }
                            }

                        }


                    }

                }
            }

            boolean flag=false;
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < m + 2; j++) {
                    if (visited[i][j]) {
                        arr[i][j] = 0;
                        flag=true;
                        res++;
                    }
                }
            }
                  time++;
            if(flag==false) break;

      
        }

        System.out.println(time + " " + res);


    }
}
