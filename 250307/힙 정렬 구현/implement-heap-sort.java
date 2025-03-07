import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        heapSort(arr);

        // 정렬된 배열 출력
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 힙 정렬 메서드
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // (1) 최대 힙 구축 (Build Max Heap)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // (2) 힙에서 요소를 하나씩 꺼내 정렬
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // 루트(최대값)를 마지막 요소와 교환
            heapify(arr, i, 0); // 감소된 크기로 다시 힙 정렬
        }
    }

    // 힙을 유지하는 메서드 (Heapify)
    public static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;  // 루트를 가장 큰 값으로 가정
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // 왼쪽 자식이 더 크다면 largest 변경
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // 오른쪽 자식이 더 크다면 largest 변경
        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // largest가 루트가 아니라면 교환 후 재귀 호출
        if (largest != rootIndex) {
            swap(arr, rootIndex, largest);
            heapify(arr, heapSize, largest);
        }
    }

    // 두 요소를 교환하는 메서드
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
