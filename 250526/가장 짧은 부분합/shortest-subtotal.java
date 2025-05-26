import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;

    // 변수 선언
    public static int[] arr = new int[MAX_N + 1];
    public static int n, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        s = sc.nextInt();
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        int ans = INT_MAX;
        int sum = 0;
        int p1 = 1, p2 = 0;

        while (p1 <= n) {
            // sum이 s보다 작고 오른쪽 포인터를 더 늘릴 수 있을 때까지 이동
            while (p2 + 1 <= n && sum < s) {
                p2++;
                sum += arr[p2];
            }

            // 현재 합이 조건을 만족하면 길이 최소값 갱신
            if (sum >= s)
                ans = Math.min(ans, p2 - p1 + 1);

            // 다음 구간 탐색 위해 왼쪽 값 제거
            sum -= arr[p1];
            p1++;
        }

        if (ans == INT_MAX)
            ans = -1;

        System.out.print(ans);
    }
}