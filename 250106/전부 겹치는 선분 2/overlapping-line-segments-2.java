import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 선분 개수
        int[][] segments = new int[n][2];  // 각 선분의 (x1, x2) 정보

        // 입력받기
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();  // x1
            segments[i][1] = sc.nextInt();  // x2
        }

        // 모든 선분 중 하나를 제거해가며 확인
        for (int i = 0; i < n; i++) {
            int maxStart = 1;  // 공통 구간의 최대 시작점
            int minEnd = 100;  // 공통 구간의 최소 끝점

            for (int j = 0; j < n; j++) {
                if (i == j) continue;  // i번째 선분을 제거

                maxStart = Math.max(maxStart, segments[j][0]);  // 최대 시작점
                minEnd = Math.min(minEnd, segments[j][1]);      // 최소 끝점
            }

            // 공통 겹치는 구간이 있는지 확인
            if (maxStart <= minEnd) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");  // 모든 경우에서 공통 구간이 없을 때
    }
}
