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

//    static void boom(int col) {
//        int cnt = 1;
//        for (int i = 1; i < n; i++) {
//            if (arr[i][col] != 0 && arr[i - 1][col] == arr[i][col]) {
//                cnt++;
//            } else {
//                if (cnt >= m && arr[i - 1][col] != 0) {  // 0이 아닐 때만 제거
//                    for (int j = 0; j < cnt; j++) {
//                        arr[i - 1 - j][col] = 0;
//                    }
//                }
//                cnt = 1;
//            }
//        }
//
//        // 마지막 그룹 처리
//        if (cnt >= m && arr[n - 1][col] != 0) {  // 0이 아닐 때만 제거
//            for (int j = 0; j < cnt; j++) {
//                arr[n - 1 - j][col] = 0;
//            }
//        }
//    }

    // 1) 0은 제외하고 세기 + 변화 여부 리턴
    static boolean boom(int col) {
        boolean changed = false;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i][col] != 0 && arr[i - 1][col] == arr[i][col]) cnt++;
            else {
                if (cnt >= m && arr[i - 1][col] != 0) {
                    changed = true;
                    for (int j = 0; j < cnt; j++) arr[i - 1 - j][col] = 0;
                }
                cnt = 1;
            }
        }
        if (cnt >= m && arr[n - 1][col] != 0) {
            changed = true;
            for (int j = 0; j < cnt; j++) arr[n - 1 - j][col] = 0;
        }
        return changed;
    }

    // 2) 한 방향에서 더 이상 터질 게 없을 때까지 안정화
    static boolean stabilize() {
        boolean any = false;
        while (true) {
            boolean roundBoom = false;
            for (int c = 0; c < n; c++) roundBoom |= boom(c);
            if (!roundBoom) break;
            any = true;
            for (int c = 0; c < n; c++) gravity(c);  // 터진 뒤 중력
        }
        return any; // 이번 안정화 단계에서 뭔가 터졌는지
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

            boolean exploded = stabilize(); // 🔸여기서 연쇄 폭발 다 처리
            // (문제 규칙에 따라) 아무것도 안 터지면 더 진행하지 않고 끝내고 싶다면:
            // if (!exploded) break;


            //90도 회전

            rotate();


            //중력
            for (int col = 0; col < n; col++) {
                gravity(col);
            }

        }

        // 최종 집계 전에 한 번 더 안정화
        stabilize();

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