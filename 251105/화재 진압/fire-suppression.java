import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 불 위치 개수
        int M = Integer.parseInt(st.nextToken()); // 소방서 개수

        long[] fire = new long[N];
        long[] station = new long[M];

        // 불 위치 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fire[i] = Long.parseLong(st.nextToken());
        }

        // 소방서 위치 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            station[i] = Long.parseLong(st.nextToken());
        }

        // 1️⃣ 소방서 위치 정렬
        Arrays.sort(station);

        long maxTime = 0;

        // 2️⃣ 각 불 위치마다 가장 가까운 소방서 찾기
        for (long firePos : fire) {
            // 소방서 중 firePos 이상인 첫 위치 찾기 (이진 탐색)
            int idx = lowerBound(station, firePos);

            long nearestDist = Long.MAX_VALUE;

            // 오른쪽에 있는 소방서까지 거리
            if (idx < M) {
                nearestDist = Math.min(nearestDist, Math.abs(firePos - station[idx]));
            }

            // 왼쪽에 있는 소방서까지 거리
            if (idx > 0) {
                nearestDist = Math.min(nearestDist, Math.abs(firePos - station[idx - 1]));
            }

            // 3️⃣ 가장 먼 불의 진압 시간 갱신
            maxTime = Math.max(maxTime, nearestDist);
        }

        System.out.println(maxTime);
    }

    // 🔍 lowerBound: 배열에서 key 이상인 첫 번째 인덱스 반환
    private static int lowerBound(long[] arr, long key) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
