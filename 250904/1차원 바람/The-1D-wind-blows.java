import java.io.*;
import java.util.*;

/*



 */


public class Main {
    static int n, m, q;
    static int[][] arr;
    static char[] arrDir;

    static void push(int row, char dir) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            q.addLast(arr[row][i]);
        }


        if (dir == 'R') {
            q.addLast(q.removeFirst());
        } else {
            q.addFirst(q.removeLast());
        }
        for (int i = 0; i < m; i++) {
            arr[row][i] = q.removeFirst();
        }

    }

    static boolean canPush(int row, char dir) {
        if (dir == 'U') {
            for (int i = 0; i < m; i++) {
                if (arr[row][i] == arr[row + 1][i]) return true;
            }

        } else {
            for (int i = 0; i < m; i++) {
                if (arr[row][i] == arr[row - 1][i]) return true;
            }
        }
        return false;
    }

    static void go(int row, char dir) {
        arrDir = new char[n];
        arrDir[row] = dir;

        //미리 방향 체크
        for (int i = row - 1; i >= 0; i--) {
            if (arrDir[i + 1] == 'L') arrDir[i] = 'R';
            else if (arrDir[i + 1] == 'R') arrDir[i] = 'L';
        }

        for (int i = row + 1; i < n; i++) {
            if (arrDir[i - 1] == 'L') arrDir[i] = 'R';
            else if (arrDir[i - 1] == 'R') arrDir[i] = 'L';
        }

        push(row, dir);
        // 전파 체크 후 이동
        for (int i = row - 1; i >= 0; i--) {
            if (canPush(i, 'U')) {// 전파된다면 이동
                push(i, arrDir[i]);
            } else {
                break;
            }
        }

        for (int i = row + 1; i < n; i++) {
            if (canPush(i, 'D')) {// 전파된다면 이동
                push(i, arrDir[i]);
            } else {
                break;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            char dir = st.nextToken().charAt(0);
            go(row, dir);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
