import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // prefix sum: pre[0] = 0, pre[i] = arr[0] + ... + arr[i-1]
        int[] pre = new int[n + 1];
        pre[0] = 0;
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }

        int res = 0;

        // 모든 구간 [j, i-1] 검사 (i는 1..n, j는 0..i-1)
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if ((pre[i] - pre[j]) % 7 == 0) {
                    res = Math.max(res, i - j);
                }
            }
        }

        System.out.println(res);
    }
}
