import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int n, m;

    static boolean find(long target) {
        int cnt = 1;

        long last = pairs[0].start;

        for (Pair pair : pairs) {
            int start = pair.start;
            int end = pair.end;

            while (true) {
                long tempNext = last + target;
                if (tempNext > end) {


                    break;
                } else {
                    if (tempNext < start) {
                        last = start;
                    } else {
                        last = tempNext;
                    }
                    cnt++;
                }

            }


        }


        if (cnt >= n) return true;


        return false;
    }

    static Pair[] pairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pairs = new Pair[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(start, end);
        }
        Arrays.sort(pairs,
                Comparator.comparing((Pair p) -> p.start)
        );


        long left = 1;
        long right = (long) Math.pow(10, 18);
        long res = Long.MIN_VALUE;


        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (find(mid)) {
                left = mid + 1;

                res = Math.max(res, mid);
            } else {
                right = mid - 1;
            }


        }
        System.out.println(res);


    }
}
