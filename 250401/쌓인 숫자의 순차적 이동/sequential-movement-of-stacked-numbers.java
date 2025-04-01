import java.util.ArrayList;
import java.util.Scanner;


class Pos {
    int x, y, idx;

    Pos(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}


public class Main {

    static Pos findTarget(int target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size = arr[i][j].size();
                for (int k = 0; k < size; k++) {
                    if (arr[i][j].get(k) == target) {
                        return new Pos(i, j, k);

                    }
                }
            }
        }

        return new Pos(-1, -1, -1);
    }


    static Pos findBiggest(Pos targetPos) {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int maxValue = 0;
        int maxX = -1;
        int maxY = -1;
        int maxIdx = -1;
        for (int k = 0; k < 8; k++) {
            int nx = targetPos.x + dx[k];
            int ny = targetPos.y + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            int size = arr[nx][ny].size();

            for (int i = 0; i < size; i++) {
                if (arr[nx][ny].get(i) > maxValue) {
                    maxX = nx;
                    maxY = ny;
                    maxValue = arr[nx][ny].get(i);
                    maxIdx = i;
                }

            }


        }

        return new Pos(maxX, maxY, maxIdx);
    }

    static ArrayList<Integer>[][] arr;
    static int n;
    static int m;
    static ArrayList<Integer> temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new ArrayList[n][n];
        temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
                arr[i][j].add(sc.nextInt());
            }
        }

        while (m-- > 0) {
            int target = sc.nextInt();

            //1. target이 있는 행과열, 인덱스 찾기
            Pos targetPos = findTarget(target);

            //2. 해당 행열 주변의 가장큰 값의 행과열, 인덱스 찾기
            Pos biggestPos = findBiggest(targetPos);
            if (biggestPos.x == -1 || biggestPos.y == -1) {
                continue;
            }

            //3. 옮기기
            for (int i = targetPos.idx; i < arr[targetPos.x][targetPos.y].size(); i++) {
                int temp = arr[targetPos.x][targetPos.y].get(i);
                arr[biggestPos.x][biggestPos.y].add(temp);

            }
            //4. 이전값 삭제
            int cnt = arr[targetPos.x][targetPos.y].size() - targetPos.idx;

            for (int i = 0; i < cnt; i++) {
                arr[targetPos.x][targetPos.y].remove(arr[targetPos.x][targetPos.y].size() - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size = arr[i][j].size();
                if (size == 0) {
                    System.out.print("None");
                }

                for (int k = size - 1; k >= 0; k--) {
                    System.out.print(arr[i][j].get(k) + " ");
                }
                System.out.println();

            }
        }


    }
}
