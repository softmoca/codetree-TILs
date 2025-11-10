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
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken()); // 값은 1 또는 2

        int left = 0;
        int ones = 0;                 // 현재 구간의 1의 개수
        int ans = Integer.MAX_VALUE;  // 최소 길이

        for (int right = 0; right < N; right++) {
            if (a[right] == 1) ones++;        // 오른쪽 확장

            // 1이 K개 이상이면, 왼쪽을 최대한 줄여서 최소 길이 갱신
            while (ones >= K) {
                ans = Math.min(ans, right - left + 1);
                if (a[left] == 1) ones--;
                left++;                        // 왼쪽 당기기
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
