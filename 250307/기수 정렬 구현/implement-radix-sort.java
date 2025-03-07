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
    private static void counting
