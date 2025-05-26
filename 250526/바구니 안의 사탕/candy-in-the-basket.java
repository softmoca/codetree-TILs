import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[4000006];

        int sum = 0;

        // 입력 처리
        while (n-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[y] += x;
        }

        // 초기 구간 합 계산 (1 ~ 2k+1)
        for (int i = 1; i <= 2 * k + 1; i++) {
            sum += arr[i];
        }

        int p1 = 1;
        int p2 = 2 * k + 2;
        int res = sum;

        // 슬라이딩 윈도우 수행
        while (p2 < arr.length) {  // 안전하게 배열 끝까지 접근
            sum = sum + arr[p2] - arr[p1];
            p2++;
            p1++;
            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}