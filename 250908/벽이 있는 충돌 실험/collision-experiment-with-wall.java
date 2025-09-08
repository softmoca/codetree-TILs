import java.io.*;
import java.util.*;

/*
- 구슬이 벽에 부딪히면 움직이지 않고 방향만 바꾼다. - 시간 1초 소요
- 둘 이상의 구슬이 만나면 사라진다.

 */


public class Main {
    static int n, m;
    static int[][] arr;

    static class Pair {
        int x, y, d;

        public Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static List<Pair> pairs = new ArrayList<>();
    static int[][] tempCnt;
    static int[][] tempDir;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void simulate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempCnt[i][j] = 0;
                tempDir[i][j] = 0;
            }
        }


        for (Pair curr : pairs) {
            int currX = curr.x;
            int currY = curr.y;
            int currD = curr.d;

            int nx = currX + dx[currD];
            int ny = currY + dy[currD];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {// 방향 반대
                curr.d = (currD + 2) % 4;
                tempCnt[currX][currY]++;
                tempDir[currX][currY] = curr.d;

            } else {
                curr.x = nx;
                curr.y = ny;
                tempCnt[nx][ny]++;
                arr[currX][currY] = 0;
                tempDir[nx][ny] = curr.d;
            }


        }

        pairs.clear();

//        List<Pair> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tempCnt[i][j] == 1) {
                    arr[i][j] = tempDir[i][j];
                    pairs.add(new Pair(i, j, arr[i][j]));
                }
            }
        }


        //      pairs = temp;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            tempCnt = new int[n][n];
            tempDir = new int[n][n];
            pairs.clear();
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                char ch = st.nextToken().charAt(0);
                int d = -1;
                if (ch == 'U') d = 0;
                else if (ch == 'D') d = 2;
                else if (ch == 'R') d = 1;
                else if (ch == 'L') d = 3;

                pairs.add(new Pair(x, y, d));
                arr[x][y] = d;
            }


            for (int i = 0; i < n * 2 + 4; i++) {
                simulate();
            }


            System.out.println(pairs.size());


        }


    }
}
