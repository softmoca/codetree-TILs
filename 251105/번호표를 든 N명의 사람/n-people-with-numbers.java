import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, t;
    static int[] arr;

   static boolean find(int k) {
    PriorityQueue<Long> heap = new PriorityQueue<>();
    int i = 0;

    // 초기 K명(또는 N명 이하) 올려서 각자의 '끝나는 시각'을 넣는다.
    while (i < k) heap.add((long) arr[i++]);

    // 대기열이 남아 있는 동안:
    // 가장 빨리 끝나는 사람의 종료시각 f를 꺼내고,
    // 그 자리로 다음 사람을 올려 f + d_i 시각에 끝나도록 넣는다.
    while (i < n) {
        long f = heap.poll();
        heap.add(f + arr[i++]);
    }

    // 남은 사람들 중 가장 늦게 끝나는 시간이 총 소요시간
    long makespan = 0;
    while (!heap.isEmpty()) makespan = heap.poll(); // 마지막이 최대
    return makespan <= t;
}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int l = 1;
        int r = n;

        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (r + l) / 2;

            if (find(mid)) {
                r = mid - 1;
                res = Math.min(res, mid);

            } else {
                l = mid + 1;
            }


        }

        System.out.println(res);

    }
}
