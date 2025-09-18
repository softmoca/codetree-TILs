import java.io.*;
import java.util.*;

public class Main {

    static boolean isEnd() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
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

//        System.out.println("D");
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        int time = 0;
        int res = 0;
        while (true) {

            int temp = 0;
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (arr[i][j] == 0 && canGo(i, j)) {

                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                                if (arr[nx][ny] == 1) {
                                    // System.out.println("sww");
                                    visited[nx][ny] = true;
                                }
                            }

                        }


                    }

                }
            }


//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    //     System.out.println(i + " " + j);
//                    System.out.print(visited[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();


            boolean falg = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) {
                        arr[i][j] = 0;
                        falg = true;
                        temp++;
                    }
                }
            }
            if (!falg) break;


            res = temp;
            time++;
        }

        System.out.println(time + " " + res);


    }
}

