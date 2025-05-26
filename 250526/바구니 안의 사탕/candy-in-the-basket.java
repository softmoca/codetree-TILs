import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[1000001];  // 좌표 범위: 0 ~ 1_000_000

        // 입력: 위치에 사탕 누적
        for (int i = 0; i < n; i++) {
            int cnt = sc.nextInt();
            int x = sc.nextInt();
            arr[x] += cnt;
        }

        int windowSize = 2 * k + 1;
        long sum = 0;
        long max = 0;

        // 초기 구간 [0, windowSize - 1]
        for (int i = 0; i < windowSize && i < arr.length; i++) {
            sum += arr[i];
        }
        max = sum;

        // 슬라이딩 윈도우: 왼쪽을 하나 빼고 오른쪽을 하나 더함
        for (int i = windowSize; i < arr.length; i++) {
            sum += arr[i] - arr[i - windowSize];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}