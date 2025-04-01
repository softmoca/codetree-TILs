import java.util.Scanner;
// 아주 많은 시간 처리 2*n보다 더 많을꺼 같지만 그려보니 2n인듯

public class Main {
    static int t;
    static int n;
    static int m;
    static int[][] dirArr;
    static int[][] nextDirArr;
    static int[][] removeArr;
    static char[] mapperDir = new char[128];
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};


    static void moveNext(int i, int j) {
        int nx = i + dx[dirArr[i][j]];
        int ny = j + dy[dirArr[i][j]];

        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {// 방향 전환
            nextDirArr[i][j] = 3 - dirArr[i][j];
            removeArr[i][j]++;
        } else {
            nextDirArr[nx][ny] = dirArr[i][j];
            removeArr[nx][ny]++;
        }


    }

    static void simulate() {
        int time = 2 * n;

        while (time-- > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nextDirArr[i][j] = -1;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    removeArr[i][j] = 0;
                }
            }

            //이동
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dirArr[i][j] >= 0) {
                        moveNext(i, j);
                    }
                }
            }
            //디버깅
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(removeArr[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            // 충돌 제거
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (removeArr[i][j] > 1) {
                        nextDirArr[i][j] = -1;
                        removeArr[i][j] = 0;
                    }
                }
            }

            //원래 배열로 복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dirArr[i][j] = nextDirArr[i][j];
                }
            }


        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            dirArr = new int[n][n];
            nextDirArr = new int[n][n];
            removeArr = new int[n][n];

            mapperDir['U'] = 0;
            mapperDir['R'] = 1;
            mapperDir['L'] = 2;
            mapperDir['D'] = 3;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dirArr[i][j] = -1;
                }
            }

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                char d = sc.next().charAt(0);
                // removeArr[x][y] = 1;
                dirArr[x][y] = mapperDir[d];
            }

            simulate();
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dirArr[i][j] >= 0) {
                        res++;
                    }
                }
            }
            System.out.println(res);


        }


    }
}
