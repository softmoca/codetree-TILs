import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = sc.nextInt();
        }
        int[][] queries = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        // 1. 점 위치 정렬
        Arrays.sort(points);

        // 2. 각 질의에 대해 구간 내 점 개수 계산
        for (int i = 0; i < Q; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            int left = lowerBound(points, a);
            int right = upperBound(points, b);

            System.out.println(right - left);
        }
    }

    // points에서 x 이상인 첫 번째 인덱스
    private static int lowerBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < x)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    // points에서 x 이하인 마지막 인덱스 + 1
    private static int upperBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= x)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}