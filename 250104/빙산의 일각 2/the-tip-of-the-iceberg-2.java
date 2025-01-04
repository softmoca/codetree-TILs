import java.util.Scanner;

public class Main {
    public static final int MAX_H = 1000;
    public static final int MAX_N = 100;
    
    public static int n;
    
    public static int[] h = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        for(int i = 0; i < n; i++)
            h[i] = sc.nextInt();

        int ans = 0;

        // 각 높이에 대해
        // 빙산 덩어리의 개수의 최댓값을 구합니다.
        for(int i = 1; i < MAX_H; i++) {
            // 물의 높이가 i일때 빙산 덩어리의 개수를 구합니다.
            int cnt = 0;

            // 가장 왼쪽에 빙산이 있는 경우의 예외를 처리해줍니다.
            if(h[0] > i)
                cnt++;

            // 바로 앞 블록은 해수면에 잠겨있고
            // 자기 자신의 블록은 해수면 위에 떠있는 경우,
            // 자기 자신 블록부터 시작하는 빙산이 하나 더 있습니다.
            for(int j = 1; j < n; j++) {
                if(h[j] > i && h[j - 1] <= i)
                    cnt++;
            }

            ans = Math.max(ans, cnt);
        }
        
        System.out.print(ans);
    }
}