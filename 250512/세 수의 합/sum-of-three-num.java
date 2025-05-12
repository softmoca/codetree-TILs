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
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        HashMap<Integer, Integer> pairSumCount = new HashMap<>();

        // 1단계: 가능한 모든 (i, j) 쌍의 합을 미리 카운팅 (i < j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                pairSumCount.put(sum, pairSumCount.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;

        // 2단계: 각 수 arr[l]에 대해, k - arr[l] 값을 만족하는 (i, j) 쌍이 존재하는지 확인
        for (int l = 0; l < n; l++) {
            int target = k - arr[l];
            if (pairSumCount.containsKey(target)) {
                ans += pairSumCount.get(target);
            }
        }

        // 같은 인덱스를 중복으로 세었을 수 있으므로, 결과를 3으로 나눠서 정답 출력
        System.out.print(ans / 3);
    }
}