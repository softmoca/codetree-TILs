import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());
        int m4 = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        int startR = r;
        int startC = c;
        
        Deque<Integer> q = new ArrayDeque<>();
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1};


        q.addLast(arr[r][c]);
        for (int i = 0; i < m1; i++) {
            r = r + dx[0];
            c = c + dy[0];
            q.addLast(arr[r][c]);

        }

        for (int i = 0; i < m2; i++) {
            r = r + dx[1];
            c = c + dy[1];
            q.addLast(arr[r][c]);
        }


        for (int i = 0; i < m3; i++) {
            r = r + dx[2];
            c = c + dy[2];
            q.addLast(arr[r][c]);
        }

        for (int i = 0; i < m4 - 1; i++) {
            r = r + dx[3];
            c = c + dy[3];
            q.addLast(arr[r][c]);
        }


        if (dir == 0) { // 반시계
            q.addFirst(q.removeLast());
        } else if (dir == 1) { // 시계
            q.addLast(q.removeFirst());
        }

        // 다시 넣기
        r = startR;
        c = startC;
        arr[r][c] = q.removeFirst();

        for (int i = 0; i < m1; i++) {
            r = r + dx[0];
            c = c + dy[0];
            arr[r][c] = q.removeFirst();

        }

        for (int i = 0; i < m2; i++) {
            r = r + dx[1];
            c = c + dy[1];
            arr[r][c] = q.removeFirst();
        }


        for (int i = 0; i < m3; i++) {
            r = r + dx[2];
            c = c + dy[2];
            arr[r][c] = q.removeFirst();
        }

        for (int i = 0; i < m4 - 1; i++) {
            r = r + dx[3];
            c = c + dy[3];
            arr[r][c] = q.removeFirst();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
