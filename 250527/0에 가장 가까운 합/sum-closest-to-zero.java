import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static int[] a = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        Arrays.sort(a, 1, n + 1);

        // 0에 가장 가까운 합을 구합니다.
        int ans = INT_MAX;

        // 구간을 잡아봅니다.
        int j = n;
        for(int i = 1; i <= n; i++) {
            if(i < j)
                ans = Math.min(ans, Math.abs(a[i] + a[j]));

            // 두 수의 합이 0 이하가 될 때 까지 j 구간을 내리면서 정답을 살펴봅니다.
            while(i < j - 1 && a[i] + a[j] > 0) {
                j--;
                ans = Math.min(ans, Math.abs(a[i] + a[j]));
            }
        }
        
        // 정답을 출력합니다.
        System.out.print(ans);
    }
}
