import java.util.ArrayDeque;
import java.util.Scanner;


public class Main {
    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};//위 우, 아래, 좌
    static int[] dy = {0, 1, 0, -1};
    static char[] dirs = new char[128];
    static ArrayDeque<int[]> ad;
    static int[][] arr;
    static int currX;
    static int currY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n][n];
        ad = new ArrayDeque<>();
        int time = 0; // 사과는 -1, 뱀 자리는 1

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            arr[x][y] = -1;//사과 위치
        }
        arr[0][0] = 1;

        dirs['U'] = 0;
        dirs['R'] = 1;
        dirs['D'] = 2;
        dirs['L'] = 3;
        currX = 0;
        currY = 0;
        ad.addLast(new int[]{0, 0});
        for (int i = 0; i < k; i++) {
            String temp = sc.next();
            char dir = temp.charAt(0);
            int cnt = sc.nextInt();

            for (int j = 0; j < cnt; j++) {
                int nx = currX + dx[dirs[dir]];
                int ny = currY + dy[dirs[dir]];
                time++;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {// 격자 벗어난 경우
                    System.out.println(time);
                    System.exit(0);
                } else if (arr[nx][ny] == -1) { // 사과 있는 경우
                    arr[nx][ny] = 1;

                    ad.addLast(new int[]{nx, ny});
                    currX = nx;
                    currY = ny;
                } else { // 사과가 없는경우
                    arr[nx][ny]++;
                    ad.addLast(new int[]{nx, ny});
                    int[] tempp = ad.removeFirst();
                    arr[tempp[0]][tempp[1]]--;
                    currX = nx;
                    currY = ny;
                }
                //       System.out.println("d");
                for (int w = 0; w < n; w++) {
                    for (int l = 0; l < n; l++) {
                        if (arr[w][l] > 1) {
                            System.out.println(time);
                            System.exit(0);
                        }
                    }
                }

            }


        }
        System.out.println(time);

        /*
          - 격자 벗어난 경우
    - 사과가 있는 경우
        - 이동한 자리 큐에 넣기
    - 사과가 없는 경우
        - 이동한 자리 큐에 넣기
        - 큐에서 제거
    - 몸이 꼬여 겹치는 경우 ( )
         */

    }
}
