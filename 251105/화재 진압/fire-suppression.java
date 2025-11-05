import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] fire = new long[N];
        long[] station = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) fire[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) station[i] = Long.parseLong(st.nextToken());

        Arrays.sort(fire);
        Arrays.sort(station);

        long answer = 0;
        int j = 0; // 소방서 포인터(단조 증가)

        for (long x : fire) {
            // x에 더 가까운 소방서가 오른쪽에 있으면 j를 옮긴다
            while (j + 1 < M &&
                   Math.abs(station[j + 1] - x) <= Math.abs(station[j] - x)) {
                j++;
            }

            long best = Math.abs(station[j] - x);   // 현재 소방서까지 거리
            if (j + 1 < M) {                        // 오른쪽 소방서도 비교(경계 처리)
                best = Math.min(best, Math.abs(station[j + 1] - x));
            }
            answer = Math.max(answer, best);        // 최댓값 갱신
        }

        System.out.println(answer);
    }
}
