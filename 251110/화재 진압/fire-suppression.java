import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] fire = new long[N];
        long[] station = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) fire[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) station[i] = Long.parseLong(st.nextToken());

        // 정렬
        Arrays.sort(fire);
        Arrays.sort(station);

        // 두 포인터로 각 화재 위치에서 가장 가까운 소방서까지 거리 계산
        long answer = 0;
        int j = 0; // 소방서 포인터

        for (int i = 0; i < N; i++) {
            long x = fire[i];

            // station[j]와 station[j+1] 중 x에 더 가까운 쪽으로 j를 전진
            while (j + 1 < M &&
                   Math.abs(x - station[j + 1]) <= Math.abs(x - station[j])) {
                j++;
            }

            long nearest = Math.abs(x - station[j]); // x에서 가장 가까운 소방서까지 거리
            answer = Math.max(answer, nearest);      // 최악(가장 오래 걸리는) 시간 갱신
        }

        System.out.println(answer);
    }
}
