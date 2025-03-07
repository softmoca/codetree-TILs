import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        // 정렬된 배열 출력
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 퀵 정렬 메서드
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);  // 피벗 왼쪽 정렬
            quickSort(arr, pivotIndex + 1, right); // 피벗 오른쪽 정렬
        }
    }

    // 배열을 분할하는 메서드 (로무토 파티션 방식)
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 피벗을 마지막 요소로 설정
        int i = left - 1; // 작은 요소들의 위치를 추적

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) { // 피벗보다 작은 경우
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right); // 피벗을 올바른 위치로 이동
        return i + 1; // 새로운 피벗 위치 반환
    }

    // 두 요소를 교환하는 메서드
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
