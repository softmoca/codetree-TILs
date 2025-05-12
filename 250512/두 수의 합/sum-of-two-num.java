import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 100000;

    public static int n, k;
    public static long[] arr = new long[MAX_N];
    public static HashMap<Long, Integer> count = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 1단계: 숫자별 등장 횟수를 모두 저장
        for (int i = 0; i < n; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }

        int ans = 0;

        // 2단계: 가능한 쌍을 계산
        for (int i = 0; i < n; i++) {
            long diff = k - arr[i];

            // 현재 arr[i]를 하나 소모했으므로 미리 count 감소
            count.put(arr[i], count.get(arr[i]) - 1);

            if (count.containsKey(diff))
                ans += count.get(diff);
        }

        System.out.print(ans);
    }
}