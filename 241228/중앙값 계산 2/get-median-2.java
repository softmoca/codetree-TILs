import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        // 최대 힙 (중앙값보다 작은 값들)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 최소 힙 (중앙값보다 큰 값들)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            
            // 중앙값보다 작은 값 -> 최대 힙
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                // 중앙값보다 큰 값 -> 최소 힙
                minHeap.offer(num);
            }
            
            // 힙 크기 균형 유지
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            
            // 홀수 번째 숫자를 읽을 때 중앙값 출력
            if (i % 2 == 0) {
                System.out.print(maxHeap.peek() + " ");
            }
        }
    }
}
