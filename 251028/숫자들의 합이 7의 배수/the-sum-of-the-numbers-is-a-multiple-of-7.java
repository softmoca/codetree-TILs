import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] preSum = new int[n + 1];
        preSum[1] = arr[0];
        for (int i = 2; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        int res = 0;

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if ((preSum[i] - preSum[j]) % 7 == 0) {
                    res = Math.max(res, i - j);
                }
            }
        }
        System.out.println(res);


    }
}
