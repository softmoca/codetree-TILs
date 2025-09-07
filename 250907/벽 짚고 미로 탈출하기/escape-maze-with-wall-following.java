import java.io.*;
import java.util.*;

/*
바라보고있는 방향으로 이동 불가 -> 반시계 회전
이동가능 1 - 밖인경우 -> 탈출
이동가능 2 - 오른쪽 짚을 벽이있다 -> 한칸이동
이동간으 3- 오른쪽 짚을 벽이 없다 -> 한칸이동 후 시ㅖ방향 회전 후 전진

이동할때만 1초 소요



1. 현재 방향으로 이동 가능한지 확인
1-1 이동가능 ->
1-2 이동 불가능 -> 반시계 방향 회전



1. 이동 가능한 방향 찾기
2. 이동
    밖인경우
    오른쪽 벽이있는경우
    오른쪽 벽이 없는경우
 */


public class Main {
    static int n;
    static char[][] arr;
    static int startX;
    static int startY;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int dir = 1;


    static int findD() {

        for (int k = 4 + dir; k > dir; k--) {
            int nx = startX + dx[k % 4];
            int ny = startY + dy[k % 4];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == '.') {
                return k % 4;
            } else if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                return k % 4;
            }
        }

        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        arr = new char[n][n];
        visited = new boolean[n][n][4];
        visited[startX][startY][dir] = true;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int time = 0;


        while (true) {

            dir = findD();

            if (dir == -1) {
                time = -1;
                break;
            }

            startX = startX + dx[dir];
            startY = startY + dy[dir];
            if (startX < 0 || startY < 0 || startX >= n || startY >= n) {// 탈출
                time++;
                break;
            }
            
            if (visited[startX][startY][dir]) {
                time = -1;
                break;

            } else {
                visited[startX][startY][dir] = true;
            }

         

            int newDir = (dir + 1) % 4;
            int tempX = startX + dx[newDir];
            int tempY = startY + dy[newDir];
            if (arr[tempX][tempY] == '.') {// 오른쪾 벽이 없는 경우
                startX = tempX;
                startY = tempY;
                time++;
                dir = newDir;
            }

            if (visited[startX][startY][dir]) {
                time = -1;
                break;

            } else {
                visited[startX][startY][dir] = true;
            }


            time++;

        }


        System.out.println(time);


    }
}
