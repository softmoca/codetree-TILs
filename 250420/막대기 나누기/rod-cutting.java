import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    
    // 변수 선언
    public static int n;
    public static int[] profit = new int[MAX_N + 1];
    
    public static int[] dp = new int[MAX_N + 1]; // dp[i] : 길이 i인 막대기를 이용해
                                                 // 얻을 수 있는 최대 수익

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            profit[i] = sc.nextInt();
        
        dp[0] = 0;

        // 점화식에 따라 값을 채워줍니다.
        for(int i = 1; i <= n; i++) {
            // 합 i를 만들기 위해
            // 마지막으로 길이가 j인 막대기를 사용한 경우에 대해 조사합니다.
            // 그 중 얻을 수 있는 최대 수익을 계산합니다.
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + profit[j]);
            }
        }

        // 길이가 n인 막대기를 이용해
        // 얻을 수 있는 최대 수익을 출력합니다.
        System.out.print(dp[n]);
    }
}
