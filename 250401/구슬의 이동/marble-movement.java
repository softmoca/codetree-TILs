import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
//                        for (int l = 0; l < n; l++) {
//                            for (int o = 0; o < n; o++) {
//                                System.out.print(nextArr[l][o].size() + " ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println();

class Pair {
    int idx, dir, cnt;

    Pair(int idx, int dir, int cnt) {
        this.idx = idx;
        this.dir = dir;
        this.cnt = cnt;
    }

}

public class Main {
    static int n;
    static char[] mapperDir = new char[128];
    static int m;
    static int t;
    static int k;
    static ArrayList<Pair>[][] arr;
    static ArrayList<Pair>[][] nextArr;

    static void move(Pair pair, int x, int y) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        for (int i = 0; i < pair.cnt; i++) {
            int nx = x + dx[pair.dir];
            int ny = y + dy[pair.dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                pair.dir = 3 - pair.dir;
                nx = x + dx[pair.dir];
                ny = y + dy[pair.dir];
            }
            x = nx;
            y = ny;
        }

        nextArr[x][y].add(pair);
    }

    static void moveAll() {
        //초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextArr[i][j] = new ArrayList<>();
            }
        }

        //로직 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].size() > 0) {
                    for (int w = 0; w < arr[i][j].size(); w++) {
                        move(arr[i][j].get(w), i, j);
                    }
                }
            }
        }
    }

    static void removeDup() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nextArr[i][j].size() > k) {// 삭제할 게 있다.
                    nextArr[i][j].sort(
                            Comparator.comparing((Pair p) -> p.cnt, Comparator.reverseOrder())
                                    .thenComparing((Pair p) -> p.idx, Comparator.reverseOrder())
                    );
                    int cntSize = nextArr[i][j].size();
                    for (int w = 0; w < cntSize - k; w++) {
                        nextArr[i][j].remove(nextArr[i][j].size() - 1);
                    }
                }
            }
        }


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt(); // 입력 구슬 개수
        t = sc.nextInt();// 시간
        k = sc.nextInt();// 살아남을수있는 최대 구슬 수

        mapperDir['U'] = 0;
        mapperDir['R'] = 1;
        mapperDir['L'] = 2;
        mapperDir['D'] = 3;
        arr = new ArrayList[n][n];
        nextArr = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextArr[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            char dir = sc.next().charAt(0);
            int cnt = sc.nextInt();
            arr[x][y].add(new Pair(i + 1, mapperDir[dir], cnt));
        }

        while (t-- > 0) {

            //1. 이동시키기 nextArr로
            moveAll();

            //2. nextArr에서 k개 이상인 곳 찾아서 제거
            removeDup();

            //3. nextArr에서 arr로 복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = nextArr[i][j];
                }
            }


        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res=res+arr[i][j].size();
                
         
            }
        }
        System.out.println(res);


    }
}
