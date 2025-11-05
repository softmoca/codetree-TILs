import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int n, t;
    static int[] arr;

    static boolean find(int target) {

        Queue<Integer> pq = new PriorityQueue<>();

        int time = 0;

        for (int i = 0; i < target; i++) {
            pq.offer(arr[i]);
        }

        for (int i = target; i < n; i++) {

            int tempMin = pq.poll();
            int size = pq.size();
            Queue<Integer> qu = new ArrayDeque<>();

            for (int j = 0; j < size; j++) {
                int temp = pq.poll() - tempMin;
                if (temp > 0) {
                    qu.offer(temp);
                    //pq.offer(temp);
                }
            }

            for (int x : qu) {
                pq.offer(x);
            }

            time = time + tempMin;
            pq.offer(arr[i]);
        }

        int size = pq.size();
        int tempMax = 0;
        for (int i = 0; i < size; i++) {
            tempMax = Math.max(tempMax, pq.poll());
        }

        time = time + tempMax;


        if (time <= t) {
            return true;
        }


        return false;
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
