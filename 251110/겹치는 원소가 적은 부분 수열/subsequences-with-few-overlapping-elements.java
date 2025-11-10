import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> cnt = new HashMap<>(); // 값 -> 윈도우 내 빈도
        int maxLen = 0;

        // [left, right] 윈도우
        for (int left = 0, right = 0; right < N; right++) {
            int x = a[right];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);

            // 어떤 값이 K개를 넘으면 조건을 만족할 때까지 왼쪽 축소
            while (cnt.get(x) > K) {
                int y = a[left];
                cnt.put(y, cnt.get(y) - 1);
                left++;
            }

            // 현재 윈도우는 항상 "모든 값의 빈도 ≤ K" 상태
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
