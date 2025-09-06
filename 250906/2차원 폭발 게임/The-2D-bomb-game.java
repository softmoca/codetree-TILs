import java.io.*;
import java.util.*;

/*

1. 열기준 m개 이상 연속 체크
2. 중력
3. 90도 회전
4. 중력

 */


public class Main {
    static int n, m, k;
    static int[][] arr;

    static void boom(int col) {
        int cnt = 1;
        int currentValue = arr[0][col];

        for (int i = 1; i < n; i++) {
            if (arr[i][col] != 0 && arr[i - 1][col] == arr[i][col]) {
                cnt++;
            } else {
                // 이전 연속 구간 처리
                if (cnt >= m && currentValue != 0) {
                    for (int j = 0; j < cnt; j++) {
                        arr[i - 1 - j][col] = 0;
                    }
                }
                cnt = 1;
                currentValue = arr[i][col];
            }
        }

        // 마지막 연속 구간 처리
        if (cnt >= m && currentValue != 0) {
            for (int j = 0; j < cnt; j++) {
                arr[n - 1 - j][col] = 0;
            }
        }
    }

    static void gravity(int col) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i][col] != 0) {
                dq.addLast(arr[i][col]);
            }
        }

        int dpSize = dq.size();

        for (int i = 0; i < n - dpSize; i++) {
            dq.addLast(0);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i][col] = dq.removeFirst();
        }


    }

    static void rotate() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - 1 - i] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp[i][j];
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (k-- > 0) {

            // 열 기준 m개 이상 연속 체크 후 제거
            for (int col = 0; col < n; col++) {
                boom(col);
            }


            // 중력
            for (int col = 0; col < n; col++) {
                gravity(col);
            }


            //90도 회전

            rotate();


            //중력
            for (int col = 0; col < n; col++) {
                gravity(col);
            }

        }

        // 열 기준 m개 이상 연속 체크 후 제거

        for (int col = 0; col < n; col++) {
            boom(col);
        }


        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 0) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);


    }
}
/*
    for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
                System.out.println();


 */