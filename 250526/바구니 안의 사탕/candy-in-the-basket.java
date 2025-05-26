import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        final int MAX_POS = 1000000;
        int[] arr = new int[MAX_POS + 2 * k + 5];  // 충분한 크기 확보

        while (n-- > 0) {
            int x = sc.nextInt(); // 사탕 개수
            int y = sc.nextInt(); // 위치
            arr[y] += x;
        }

        int windowSize = 2 * k + 1;
        long sum = 0;

        // ✅ 초기 구간: 0 ~ 2k
        for (int i = 0; i <= 2 * k; i++) {
            sum += arr[i];
        }

        int p1 = 0;
        int p2 = 2 * k;
        long res = sum;

        while (p2 + 1 < arr.length) {
            p1++;
            p2++;
            sum = sum + arr[p2] - arr[p1 - 1];
            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}