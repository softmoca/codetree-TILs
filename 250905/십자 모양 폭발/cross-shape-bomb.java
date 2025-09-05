import java.io.*;
import java.util.*;

/*

1. 터지는 부분 0으로 체크
2. 중력 작용

 */


public class Main {


    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;


        int size = arr[start][end];
        arr[start][end] = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        for (int k = 0; k < 4; k++) {
            int x = start;
            int y = end;

            for (int i = 1; i < size; i++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                x = nx;
                y = ny;
                arr[x][y] = 0;
            }
        }


        for (int col = 0; col < n; col++) {
            gravity(col);

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }

    static void gravity(int col) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (arr[n - 1 - i][col] != 0) {
                q.addLast(arr[n - 1 - i][col]);

            }
        }

        int qSize = q.size();
        for (int i = 0; i < n - qSize; i++) {
            q.addLast(0);
        }

        for (int i = 0; i < n; i++) {
            arr[n - 1 - i][col] = q.pollFirst();
        }


    }


}
