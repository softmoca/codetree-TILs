import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 50000;
    
    // 변수 선언
    public static int n, k;
    public static int[] pos = new int[MAX_N];
     
    public static boolean isPossible(int mid) {
        int cnt = 1;
        int idx = 0;            // 모든 점을 제거하기 위해 몇개의 폭탄이 필요한지 확인합니다.
        for(int i = 0; i < n; i++) {
            if(pos[i] - pos[idx] <= 2 * mid) continue;
            else {
                cnt++;
                idx = i;
            }
        }
    
        return cnt <= k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++) pos[i] = sc.nextInt();

        Arrays.sort(pos, 0, n);

        int lo = 0;                         // 답이 될 수 있는 가장 작은 숫자 값을 설정합니다.
        int hi = (int)1e9;                  // 답이 될 수 있는 가장 큰 숫자 값을 설정합니다.
        int ans = (int)1e9;                 // 답을 저장합니다.

        while(lo <= hi) {                   // [lo, hi]가 유효한 구간이면 계속 수행합니다.
            int mid = (lo + hi) / 2;        // 가운데 위치를 선택합니다.
            if(isPossible(mid)) {           // 결정문제에 대한 답이 Yes라면
                hi = mid - 1;               // 왼쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 right를 바꿔줍니다.
                ans = Math.min(ans, mid);   // 답의 후보들 중 최솟값을 계속 갱신해줍니다.
            }
            else
                lo = mid + 1;               // 결정문제에 대한 답이 No라면 right를 바꿔줍니다.
        }
        
        // 정답을 출력합니다.
        System.out.print(ans);
    }
}
