import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;

    // 변수 선언
    public static int n, m;
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

// 초기화
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++)
                dist[i][j] = Integer.MAX_VALUE;
            dist[i][i] = 0;
        }

        // 그래프를 인접행렬로 표현
        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            // x -> y 간선이
            // 여러 개 주어질 수도 있다고 하였으므로
            // 최솟값을 계속 갱신해줍니다.
            dist[x][y] = Math.min(dist[x][y], z);
        }
        
        for(int k = 1; k <= n; k++)
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++) {
                    // 핵심: 경로가 없으면 건너뛰기
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }


        // 모든 쌍에 대한 최단거리 결과를 출력합니다.
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                // 불가능한 경우에는 -1을 출력합니다.
                if(dist[i][j] == (int)1e9)
                    System.out.print(-1 + " ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
