import java.io.*;
import java.util.*;

/*

1. 시계방향 회전
2. 중력 - deque사용
3. 합차기


 */


public class Main {
    static int[][] arr = new int[4][4];
    static int[][] temp = new int[4][4];

    static void rotate() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[j][3 - i] = arr[i][j];
            }
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = temp[i][j];
            }
        }

    }

    static void gravity(int col) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 3; i >= 0; i--) {
            if (arr[i][col] != 0) {
                dq.addLast(arr[i][col]);
            }
        }
        for (int i = 0; i < 4 - dq.size(); i++) {
            dq.addLast(0);
        }
        for (int i = 3; i >= 0; i--) {
            arr[i][col] = dq.removeFirst();

        }

    }

    static void go(int col) {
        Deque<Integer> dq = new ArrayDeque<>();

        if (arr[0][col] == arr[1][col] && arr[2][col] == arr[3][col]) {
            dq.addLast(2 * arr[2][col]);
            dq.addLast(2 * arr[0][col]);
            dq.addLast(0);
            dq.addLast(0);
        } else if (arr[2][col] == arr[3][col]) {
            dq.addLast(2 * arr[2][col]);
            dq.addLast(arr[1][col]);
            dq.addLast(arr[0][col]);
            dq.addLast(0);
        } else if (arr[2][col] == arr[1][col]) {
            dq.addLast(arr[3][col]);
            dq.addLast(2 * arr[2][col]);
            dq.addLast(arr[0][col]);
            dq.addLast(0);

        } else if (arr[1][col] == arr[0][col]) {
            dq.addLast(arr[3][col]);
            dq.addLast(arr[2][col]);
            dq.addLast(2 * arr[1][col]);
            dq.addLast(0);
        } else {
            dq.addLast(arr[3][col]);
            dq.addLast(arr[2][col]);
            dq.addLast(arr[1][col]);
            dq.addLast(arr[0][col]);
        }

        for (int i = 3; i >= 0; i--) {
            arr[i][col] = dq.removeFirst();
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        char d = br.readLine().charAt(0);

        //회전
        if (d == 'L') {
            for (int i = 0; i < 3; i++) {
                rotate();
            }
        } else if (d == 'R') {
            rotate();
        } else if (d == 'U') {
            for (int i = 0; i < 2; i++) {
                rotate();
            }
        }


        // 중력
        for (int i = 0; i < 4; i++) {
            gravity(i);
        }


        //합치기
        for (int i = 0; i < 4; i++) {
            go(i);
        }


        // 회전 복구
        if (d == 'L') {
            rotate();
        } else if (d == 'R') {
            for (int i = 0; i < 3; i++) {
                rotate();
            }
        } else if (d == 'U') {
            for (int i = 0; i < 2; i++) {
                rotate();
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
