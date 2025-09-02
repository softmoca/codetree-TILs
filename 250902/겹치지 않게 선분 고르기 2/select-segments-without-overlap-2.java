import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(pairs,
                Comparator.comparing(
                        (Pair p) -> p.start

                )
        );
        


        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(pairs[i].start > pairs[j].end) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                
            }

        }
        
        
        int res=0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
        


    }
}
