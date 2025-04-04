import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Pair {
    int idx, row, col, weight, dir;

    Pair(int idx, int row, int col, int weight, int dir) {
        this.idx = idx;
        this.row = row;
        this.col = col;
        this.weight = weight;
        this.dir = dir;
    }


}


public class Main {
    static int n;
    static int m;
    static int t;
    static char[] dirMapper = new char[128];
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static ArrayList<Pair> pairs = new ArrayList<>();
    static int[][] countArr;
    static boolean[][] countArrC;

    static void moveAll() {
        for (int i = 0; i < pairs.size(); i++) {
            Pair currPair = pairs.get(i);
            int nx = currPair.row + dx[currPair.dir];
            int ny = currPair.col + dy[currPair.dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                currPair.dir = 3 - currPair.dir;
            } else {
                currPair.row = nx;
                currPair.col = ny;
            }


        }

    }

    static void boom() {
        // Step 1: countArr 초기화
        for (Pair p : pairs) {
            countArr[p.row][p.col]++;
        }

        // Step 2: 충돌이 일어난 위치 별로 최종 Pair 저장
        Map<String, Pair> mergedMarbles = new HashMap<>();

        for (Pair p : pairs) {
            int x = p.row;
            int y = p.col;

            if (countArr[x][y] >= 2) { // 충돌하는 경우
                String key = x + "," + y;

                if (!mergedMarbles.containsKey(key)) {
                    mergedMarbles.put(key, new Pair(p.idx, x, y, p.weight, p.dir));
                } else {
                    Pair existing = mergedMarbles.get(key);
                    int newWeight = existing.weight + p.weight;

                    // 번호가 더 크면 dir, idx 업데이트
                    if (existing.idx < p.idx) {
                        mergedMarbles.put(key, new Pair(p.idx, x, y, newWeight, p.dir));
                    } else {
                        mergedMarbles.put(key, new Pair(existing.idx, x, y, newWeight, existing.dir));
                    }
                }
            }
        }

        // Step 3: 충돌 없는 구슬 + 충돌 후 살아남은 구슬로 리스트 갱신
        ArrayList<Pair> temp = new ArrayList<>();

        for (Pair p : pairs) {
            int x = p.row;
            int y = p.col;
            String key = x + "," + y;

            if (countArr[x][y] >= 2) {
                if (mergedMarbles.containsKey(key)) {
                    temp.add(mergedMarbles.get(key));
                    mergedMarbles.remove(key); // 이미 추가된 위치는 다시 추가하지 않음
                }
            } else {
                temp.add(p);
            }
        }

        // Step 4: countArr 초기화
        for (Pair p : pairs) {
            countArr[p.row][p.col] = 0;
        }

        pairs = temp;
    }

    static void simulate() {

        moveAll();
        // 디버깅
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(countArr[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        for (int o = 0; o < pairs.size(); o++) {
//            Pair curr = pairs.get(o);
//            System.out.println(curr.idx + " " + curr.row + " " + curr.col
//                    + " " + curr.weight + " " + curr.dir);
//        }
//        System.out.println();

        boom();


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        /*
        1. 모든 구슬 움직이기 -> 범위 벗어나면 방향 반대
        2. 충돌확인
        2-1. 충돌시 -> 무게는 합쳐진다. 방향은 큰 번호, 번호도 큰 번호
         */
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        countArr = new int[n][n];
        countArrC = new boolean[n][n];
        dirMapper['U'] = 0;
        dirMapper['R'] = 1;
        dirMapper['L'] = 2;
        dirMapper['D'] = 3;

        for (int i = 0; i < m; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            char d = sc.next().charAt(0);
            int w = sc.nextInt();
            int dir = dirMapper[d];
            pairs.add(new Pair(i, row, col, w, dir));
        }

        while (t-- > 0) {
            simulate();
        }

        System.out.println(pairs.size());
        int res = 0;
        for (int i = 0; i < pairs.size(); i++) {
            res = Math.max(res, pairs.get(i).weight);

        }
        System.out.println(res);


    }
}


/*

4 5 2
1 2 L 5
2 3 U 2
3 1 R 2
4 2 U 3
3 4 D 5
 */