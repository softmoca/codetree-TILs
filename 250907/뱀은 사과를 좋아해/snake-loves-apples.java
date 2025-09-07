import java.io.*;
import java.util.*;

/*
종료
    1. 전부이동
    2. 격자 벗어남.
    3. 몸이꼬여 서로 겹침


     이동 했는데 사과가 있따
        -
    이동했는대 사과가 없다.

 */


public class Main {
    static int n, m, k;
    static int[][] arr;
    static int[][] vistied;
    static int currX = 0;
    static int currY = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Deque<int[]> dq = new ArrayDeque<>();

    static boolean go(char d) {
        int k = -1;
        if (d == 'U') {
            k = 0;
        } else if (d == 'D') {
            k = 2;
        } else if (d == 'L') {
            k = 3;
        } else if (d == 'R') {
            k = 1;
        }

        int nx = currX + dx[k];
        int ny = currY + dy[k];
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            return true;
        }

        if (vistied[nx][ny] == 1) {
            return true;
        }

        if (arr[nx][ny] == 0) {// 사과없다.
            dq.addFirst(new int[]{nx, ny});
            vistied[nx][ny] = 1;
            
            int[] temp = dq.removeLast();
            vistied[temp[0]][temp[1]] = 0;

        } else {// 사과 있따
            dq.addFirst(new int[]{nx, ny});
            vistied[nx][ny] = 1;
            arr[nx][ny] = 0;
        }
        currX = nx;
        currY = ny;


        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = 1;

        }
        vistied = new int[n][n];

        vistied[0][0] = 1;
        dq.addFirst(new int[]{0, 0});

        int time = 0;
        A:
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int cnt = Integer.parseInt(st.nextToken());

            for (int i = 0; i < cnt; i++) {
                time++;
                if (go(d)) break A;
            }

        }


        System.out.println(time);


    }
}
