import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        radixSort(arr, n);

        // 정렬된 배열 출력
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 기수 정렬 메서드
    public static void radixSort(int[] arr, int n) {
        int max = getMax(arr, n); // 배열 내 최댓값 찾기

        // 자릿수마다 정렬 수행
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, n, exp);
        }
    }

    // 자릿수별 정렬 (계수 정렬 사용)
    private static void countingSortByDigit(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10]; // 0~9까지의 숫자 카운트

        // 현재 자릿수 값의 개수 세기
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // 누적합 계산 (위치를 결정하기 위해)
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 배열을 정렬된 순서로 재배열
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // 원래 배열에 복사
        System.arraycopy(output, 0, arr, 0, n);
    }

    // 배열에서 최댓값 찾기
    private static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
