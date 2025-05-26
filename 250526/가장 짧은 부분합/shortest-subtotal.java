import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int p1 = 1, p2 = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while (p1 <= n) {
            // 오른쪽 포인터를 옮기며 합이 s 이하인 최대 구간을 찾음
            while (p2 + 1 <= n && sum + arr[p2 + 1] <= s) {
                p2++;
                sum += arr[p2];
            }

            if (p2 + 1 == n && sum < s) break;

            if (sum >= s) {
                res = Math.min(res, p2 - p1 + 1);
            }

            // 왼쪽 포인터 이동 (구간 축소)
            sum -= arr[p1];
            p1++;
        }

        System.out.println(res);
    }
}