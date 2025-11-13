import java.io.*;
import java.util.*;

public class Main {
    static class Job {
        int score, deadline;
        Job(int s, int d) { score = s; deadline = d; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Job[] a = new Job[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            a[i] = new Job(score, deadline);
        }

        // 1) 마감시간 오름차순
        Arrays.sort(a, (x, y) -> x.deadline - y.deadline);

        // 2) 선택한 작업 점수를 담는 최소힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Job j : a) {
            pq.offer(j.score);                 // 일단 선택
            if (pq.size() > j.deadline) {      // 마감시간까지 할 수 있는 개수 초과면
                pq.poll();                     // 가장 점수 낮은 것 버리기
            }
        }

        long ans = 0;
        while (!pq.isEmpty()) ans += pq.poll();
        System.out.println(ans);
    }
}
