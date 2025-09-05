import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, boomCnt;
    static int[][] arr;

    static int[] find(int col) {
        for (int i = 0; i < n; i++) {
            if (arr[i][col] != 0) {
                return new int[]{i, col};
            }

        }

        return new int[]{-1, -1};
    }

    static void boom(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int size = arr[x][y];
        arr[x][y] = 0;

        for (int k = 0; k < 4; k++) {
            int i = x;
            int j = y;
            for (int w = 1; w < size; w++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                arr[nx][ny] = 0;
                i = nx;
                j = ny;
            }
        }
    }

    static void gravity(int col) {

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i][col] != 0) {
                dq.addLast(arr[i][col]);
            }
        }
        int s = dq.size();
        for (int i = 0; i < n - s; i++) {
            dq.addLast(0);
        }
        for (int i = n - 1; i >= 0; i--) {
            arr[i][col] = dq.pollFirst();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        boomCnt = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (boomCnt-- > 0) {
            int col = Integer.parseInt(br.readLine()) - 1;

            // 폭팔할 좌표 찾기 - 없으면 패쓰
            int[] curr = find(col);
            if (curr[0] == -1 && curr[1] == -1) continue;


            //폭팔하며 0으로 체크
            boom(curr[0], curr[1]);


            // 중력
            for (int c = 0; c < n; c++) {
                gravity(c);
            }
   
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println();

    }
}
