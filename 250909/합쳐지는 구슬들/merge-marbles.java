import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static class Pair {
        int x, y, num, dir, w;

        Pair(int x, int y, int num, int dir, int w) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.w = w;
        }

    }

    static int n, m, t;
    static List<Pair> pairs = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            char d = st.nextToken().charAt(0);
            int dir = -1;
            int w = Integer.parseInt(st.nextToken());

            if (d == 'U') dir = 0;
            else if (d == 'R') dir = 1;
            else if (d == 'D') dir = 2;
            else if (d == 'L') dir = 3;

            pairs.add(new Pair(x, y, i, dir, w));

        }


        while (t-- > 0) {


            //이동
            for (Pair p : pairs) {
                int x = p.x, y = p.y, dir = p.dir, w = p.w, num = p.num;

                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    p.dir = (dir + 2) % 4;
                } else {
                    p.x = nx;
                    p.y = ny;
                }
            }


            // 중복처리
            Pair[][] temp = new Pair[n][n];


            for (Pair p : pairs) {
                int x = p.x, y = p.y, dir = p.dir, w = p.w, num = p.num;
                if (temp[x][y] == null) {
                    temp[x][y] = new Pair(x, y, dir, w, num);
                } else {
                    Pair tempP = temp[x][y];
                    int nextNum = -1;
                    int nextDir = -1;
                    if (tempP.num > num) {
                        nextNum = tempP.num;
                        nextDir = tempP.dir;
                    } else {
                        nextNum = num;
                        nextDir = dir;
                    }
                    temp[x][y] = new Pair(x, y, nextNum, nextDir, tempP.w + w);
                }


            }


            pairs.clear();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp[i][j] != null) {
                        pairs.add(temp[i][j]);
                    }
                }
            }


        }
        System.out.print(pairs.size() + " ");
        int res = 0;
        for (Pair p : pairs) {
            res = Math.max(res, p.w);
        }

        System.out.println(res);

    }
}
