import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;

    // 변수 선언
    public static int[] arr = new int[MAX_N + 1];
    public static int n, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        int ans = INT_MAX;

        int sumVal = 0;
        int right = 1;
        for (int left = 1; left <= n; left++) {
            // 구간 내 합이 s보다 작으면 계속 진행합니다.
            while (right <= n && sumVal < s) {
                sumVal += arr[right];
                right++;
            }

            // 만약 최대한 이동했는데도 sumVal이 s가 되지 못했다면  탐색을 종료합니다.
            if (sumVal < s)
                break;

            // 현재 구간 [left,right]는  i를 시작점으로 하는 가장 짧은 구간이므로
            ans = Math.min(ans, right - left + 1);

            // 다음 구간으로 넘어가기 전에 arr[left]에 해당하는 값은 구간에서 제외시킵니다.
            sumVal -= arr[left];
        }

        if (ans == INT_MAX)
            ans = -1;

        System.out.print(ans);
    }
}
