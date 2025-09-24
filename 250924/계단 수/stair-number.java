import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }


        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {

                int temp = 0;

                if (j - 1 >= 0) {
                    temp += (dp[i - 1][j - 1] % 1000000007);
                }
                if (j + 1 <= 9) {
                    temp += (dp[i - 1][j + 1] % 1000000007);
                }
                dp[i][j] = temp;
            }
        }


        int res = 0;
        for (int i = 0; i <= 9; i++) {
            res += (dp[n][i] % 1000000007);
        }

        System.out.println(res);


    }
}
