import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static class Pair {
        int start;
        int end;
        int money;

        public Pair(int start, int end, int money) {
            this.start = start;
            this.end = end;
            this.money = money;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(s, e, m);
        }

        Arrays.sort(pairs,
                Comparator.comparing(
                        (Pair p) -> p.start

                )
        );


        for (int i = 0; i < n; i++) {
            dp[i] = pairs[i].money;
            for (int j = 0; j < i; j++) {
                if (pairs[i].start > pairs[j].end) {
                    dp[i] = Math.max(dp[i], dp[j] + pairs[i].money);
                }

            }

        }


        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);


    }
}
