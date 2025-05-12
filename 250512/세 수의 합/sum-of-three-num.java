import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 1000;

    public static int n, k;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> pairSumCount = new HashMap<>();
        int ans = 0;

        // 1단계: 앞에서부터 i, j 조합의 합을 기록 (i < j)
        for (int i = 0; i < n; i++) {
            // 2단계: 현재 arr[i]를 세 번째 수로 놓고 (j < i < l), (k - arr[i])인 쌍의 개수를 정답에 더함
            int needed = k - arr[i];
            if (pairSumCount.containsKey(needed))
                ans += pairSumCount.get(needed);

            // 1단계: 현재까지의 arr[j]들로 새로운 쌍을 만들어 map에 기록
            for (int j = 0; j < i; j++) {
                int sum = arr[i] + arr[j];
                pairSumCount.put(sum, pairSumCount.getOrDefault(sum, 0) + 1);
            }
        }

        System.out.print(ans);
    }
}