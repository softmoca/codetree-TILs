import java.io.*;
import java.util.*;

/*

1. 회전
2. 평균

 */


public class Main {
    static int n, m, q;
    static int[][] arr;

    static void rotate(int r1, int c1, int r2, int c2) {
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = c1; i <= c2; i++) {
            q.addLast(arr[r1][i]);
        }

        for (int i = r1 + 1; i < r2; i++) {
            q.addLast(arr[i][c2]);
        }
        for (int i = c2; i >= c1; i--) {
            q.addLast(arr[r2][i]);
        }

        for (int i = r2 - 1; i > r1; i--) {
            q.addLast(arr[i][c1]);
        }

        q.addFirst(q.removeLast());

        //다시 넣기

        for (int i = c1; i <= c2; i++) {
            arr[r1][i] = q.removeFirst();
            //q.addLast(arr[r1][i]);
        }

        for (int i = r1 + 1; i < r2; i++) {
            arr[i][c2] = q.removeFirst();
            //q.addLast(arr[i][c2]);
        }
        for (int i = c2; i >= c1; i--) {
            arr[r2][i] = q.removeFirst();
            //q.addLast(arr[r2][i]);
        }

        for (int i = r2 - 1; i > r1; i--) {
            arr[i][c1] = q.removeFirst();
            //q.addLast(arr[i][c1]);
        }


     //   System.out.println();


    }

    static void go(int r1, int c1, int r2, int c2) {
        int[][] temp = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int cnt = 1;
                int sum = arr[i][j];

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    cnt++;
                    sum = sum + arr[nx][ny];


                }
                temp[i][j] = sum / cnt;


            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) continue;
                arr[i][j] = temp[i][j];
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            rotate(r1, c1, r2, c2);
            go(r1, c1, r2, c2);


        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
