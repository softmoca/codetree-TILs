import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0; j--) {
                if (j - arr[i] < 0) continue;
                if (dp[j - arr[i]] == Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);

            }

        }

        if (dp[m] == Integer.MAX_VALUE) System.out.println("No");
        else System.out.println("Yes");


    }
}
