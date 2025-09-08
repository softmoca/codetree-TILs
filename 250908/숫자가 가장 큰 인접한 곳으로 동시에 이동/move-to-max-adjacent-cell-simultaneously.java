import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, m, t;
    static int[][] arr;
    static List<Pair> pairs = new ArrayList<>();
    static int[][] temp;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Pair find(Pair pair) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int max = 0;
        for (int k = 0; k < 4; k++) {
            int nx = pair.x + dx[k];
            int ny = pair.y + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            max = Math.max(max, arr[nx][ny]);
        }
        for (int k = 0; k < 4; k++) {
            int nx = pair.x + dx[k];
            int ny = pair.y + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (arr[nx][ny] == max) {
                return new Pair(nx, ny);
            }
        }


        return new Pair(-1, -1);
    }

    static void simulate() {

        temp = new int[n][n];
        int size = pairs.size();

        for (int i = 0; i < size; i++) {
            Pair pair = pairs.get(i);
            Pair nextPair = find(pair);
            temp[nextPair.x][nextPair.y]++;
        }
        pairs.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 1) {
                    pairs.add(new Pair(i, j));
                }
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            pairs.add(new Pair(x1, y1));
        }


        while (t-- > 0) {
            simulate();
        }
        System.out.println(pairs.size());


    }
}
