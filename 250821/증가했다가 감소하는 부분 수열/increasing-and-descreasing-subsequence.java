import java.util.Scanner;

public class Main {
    public static final int MAX_K = 2;
    public static final int MAX_N = 1000;
    
    public static int n;
    public static int[] arr = new int[MAX_N];
    
    // dp[i][j] :
    // 마지막으로 고른 원소의 위치가 i이면서
    // 현재 증가-감소 상태가 j일때 (증가하는 중이면 j = 0, 감소하는 중이면 j = 1)
    // 부분 수열 중 최장 증가-감소 부분 수열의 길이
    public static int[][] dp = new int[MAX_N][MAX_K];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < n; i++){
            // 현재 위치에서 시작할 때에는
            // dp값이 1이 되므로
            // 초기 셋팅은 1입니다.
            // 단, 시작은 증가, 감소 상태 둘 다 가능합니다.
            dp[i][0] = 1;
            dp[i][1] = 1;

            for(int j = 0; j < i; j++) {
                // Case 1. 계속 증가하는 경우에는 j = 0일 때에 대해
                // i번째 보다 앞에 있는 원소들 중 arr[i]보다는 값이 작은 곳에 
                // 새로운 원소인 arr[i]를 추가했을 때의 
                if(arr[j] < arr[i])
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                
                // Case 2. 계속 감소하는 경우에는 j = 1일 때에 대해
                // i번째 보다 앞에 있는 원소들 중  arr[i]보다는 값이 큰 곳에 
                // 새로운 원소인 arr[i]를 추가했을 때
                if(arr[j] > arr[i])
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
            }

            // Case 3.
            // 정확히 현재 위치에서 증가하던 것을 멈추고, 감소하는 것으로 방향을 옮기는 경우입니다.
            // 이 경우 j = 0에 있던 값이 j = 1로 그대로 옮겨질 수 있습니다.
            dp[i][1] = Math.max(dp[i][1], dp[i][0]);
        }

        // 마지막 원소의 위치가 i일 때의 부분 수열들 중
        // 가장 길이가 긴 증가-감소 부분 수열을 고릅니다.
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans = Math.max(ans, dp[i][1]);

        System.out.print(ans);
    }
}
