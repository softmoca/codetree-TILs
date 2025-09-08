import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n;
    static int[][] arr;
    static List<Pair> pairs = new ArrayList<>();


    static void go(int x, int y) {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        int max = 0;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            max = Math.max(max, arr[nx][ny]);
        }


        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (arr[nx][ny] == max) {

                int curr = arr[x][y];
                int next = arr[nx][ny];
                pairs.set(curr - 1, new Pair(nx, ny, max));
                pairs.set(next - 1, new Pair(x, y, arr[x][y]));


                int temp = arr[nx][ny];
                arr[nx][ny] = arr[x][y];
                arr[x][y] = temp;


                return;
            }

        }
    }

    static class Pair {
        int x;
        int y;
        int num;

        Pair(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }


        while (m-- > 0) {


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pairs.add(new Pair(i, j, arr[i][j]));
                }
            }


            pairs.sort(
                    Comparator.comparing(
                            (Pair p) -> p.num
                    )
            );


            for (Pair pair : pairs) {
                go(pair.x, pair.y);
            }
            pairs.clear();


        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
