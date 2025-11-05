import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> freq = new HashMap<>();
        int ans = 0, l = 0;

        for (int r = 0; r < N; r++) {
            // 오른쪽 값 추가
            freq.put(a[r], freq.getOrDefault(a[r], 0) + 1);

            // 어떤 값이 K를 초과하면 왼쪽을 줄여서 조건 회복
            while (freq.get(a[r]) > K) {
                freq.put(a[l], freq.get(a[l]) - 1);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        System.out.println(ans);
    }
}
