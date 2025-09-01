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
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>m) continue;
            dp[arr[i]] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - arr[j] >= 0 && dp[i - arr[j]] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
        if (dp[m] == -1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }


    }
}

