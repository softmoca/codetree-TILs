import java.util.Scanner;

public class Main {    
    public static final int MAX_N = 100;
    
    // 변수 선언
    public static int n;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                graph[i][j] = sc.nextInt();
            
        // i -> i로는 갈 수 있다고 전부 표시를 해줘야 합니다.
        for(int i = 1; i <= n; i++)
            graph[i][i] = 1;

        for(int k = 1; k <= n; k++) // 확실하게 거쳐갈 정점을 1번부터 N번까지 순서대로 정의합니다.
            for(int i = 1; i <= n; i++) // 고정된 k에 대해 모든 쌍 (i, j)를 살펴봅니다.
                for(int j = 1; j <= n; j++)
                    // i -> k, k -> j로 가능 길이 있다면
                    // i -> j도 가능하다는 뜻입니다.
                    if(graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1;

        // 모든 쌍에 대한 이동 가능 결과를 출력합니다.
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++)
                System.out.print(graph[i][j] + " ");
            System.out.println();
        }
    }
}
