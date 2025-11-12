import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        long prefix = 0;              // 누적합 S[i]
        long minPrefix = 0;           // 지금까지 본 누적합 중 최소값 min S[0..i]
        long best = Long.MIN_VALUE;   // 최대 부분합

        for (int x : a) {
            prefix += x;                          // 현재까지 누적합
            best = Math.max(best, prefix - minPrefix); // 끝이 여기인 최대 부분합
            minPrefix = Math.min(minPrefix, prefix);   // 최소 누적합 갱신
        }

        System.out.println(best);
    }
}
