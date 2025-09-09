import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static class Pair {
        int x, y, dir, num, v;

        Pair(int x, int y, int dir, int num, int v) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.num = num;
            this.v = v;
        }

    }

    static int n, m, t, k;
    static List<Pair>[][] arr;
    static List<Pair> pairs = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new List[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            char d = st.nextToken().charAt(0);
            int dir = -1;
            int v = Integer.parseInt(st.nextToken());

            if (d == 'U') dir = 0;
            else if (d == 'R') dir = 1;
            else if (d == 'D') dir = 2;
            else if (d == 'L') dir = 3;

            pairs.add(new Pair(x, y, dir, i, v));
        }


        while (t-- > 0) {

            //이동
            for (Pair p : pairs) {
                int x = p.x, y = p.y, dir = p.dir, v = p.v;

                for (int i = 0; i < v; i++) {
                    int nx = x + dx[dir], ny = y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        dir = (dir + 2) % 4;
                        x = x + dx[dir];
                        y = y + dy[dir];

                    } else {
                        x = nx;
                        y = ny;

                    }
                }
                p.x = x;
                p.y = y;
                p.dir = dir;


            }
        //    System.out.println();

            // arr 이동 반영
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j].clear();
                }
            }


            for (Pair p : pairs) {
                int x = p.x, y = p.y, dir = p.dir, v = p.v;
                arr[x][y].add(p);
            }


            // 정렬 후 k 체크 후 제거
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (arr[i][j].size() > k) {
                        arr[i][j].sort(
                                Comparator.comparing((Pair p) -> -p.v)
                                        .thenComparing((Pair p) -> -p.num)
                        );

                        int removeCnt = arr[i][j].size() - k;
                        for (int w = 0; w < removeCnt; w++) {
                            arr[i][j].remove(arr[i][j].size() - 1);
                        }


                    }


                }
            }

            // pairs에 다시 저장
            pairs.clear();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!arr[i][j].isEmpty()) {
                        pairs.addAll(arr[i][j]);
                    }
                }
            }


        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!arr[i][j].isEmpty()) {
                    res = res + arr[i][j].size();
                }
            }
        }
        System.out.println(res);


    }
}
