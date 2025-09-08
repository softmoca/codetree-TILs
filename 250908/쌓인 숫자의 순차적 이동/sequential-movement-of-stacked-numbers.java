import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, m;
    static List<Integer>[][] arr;
    static int[][] arrMax;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n][n];
        arrMax = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i][j].add(x);
                arrMax[i][j] = x;
            }
        }
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            int targetX = -1;
            int targetY = -1;
            int targetIdx = -1;

            //좌표와 순서 찾가
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j].contains(target)) {
                        targetX = i;
                        targetY = j;
                        targetIdx = arr[i][j].indexOf(target);
                    }
                }
            }


            //이동할곳 있는지 확인
            boolean flag = false;

            for (int k = 0; k < 8; k++) {
                int nx = targetX + dx[k];
                int ny = targetY + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (!arr[nx][ny].isEmpty()) {
                    flag = true;
                }


            }
            if (!flag) continue;

            //주변 가장 큰 값 찾기
            int max = 0;
            for (int k = 0; k < 8; k++) {
                int nx = targetX + dx[k];
                int ny = targetY + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                max = Math.max(max, arrMax[nx][ny]);

            }


            //주변 가장 큰 값 이동 방향 찾기
            int dir = -1;
            for (int k = 0; k < 8; k++) {
                int nx = targetX + dx[k];
                int ny = targetY + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (arrMax[nx][ny] == max) {
                    dir = k;
                    break;
                }


            }


            //이동
            int moveSize = arr[targetX][targetY].size() - targetIdx;

            // 새로운 자리로 이동
            for (int i = targetIdx; i < arr[targetX][targetY].size(); i++) {
                arr[targetX + dx[dir]][targetY + dy[dir]].add(arr[targetX][targetY].get(i));
            }

            //기존자리 제거
            //          System.out.println();
            for (int i = 0; i < moveSize; i++) {
                arr[targetX][targetY].remove(arr[targetX][targetY].size() - 1);
            }

//            System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int maxx = 0;
                    for (int w = 0; w < arr[i][j].size(); w++) {
                        maxx = Math.max(maxx, arr[i][j].get(w));
                    }
                    arrMax[i][j] = maxx;

                }
            }


        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].isEmpty()) {
                    System.out.println("None");
                } else {

                    int size = arr[i][j].size();
                    for (int w = size - 1; w >= 0; w--) {
                        System.out.print(arr[i][j].get(w) + " ");
                    }
                    System.out.println();


                }

            }
        }


    }
}
