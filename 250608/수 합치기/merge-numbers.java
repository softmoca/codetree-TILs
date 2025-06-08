import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {    
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static int[] arr = new int[MAX_N];
    
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 우선순위 큐에 원소들을 전부 넣어줍니다.
        for(int i = 0; i < n; i++)
            pq.add(arr[i]);

        // 원소가 2개 이상이면 계속
        // 가장 작은 숫자 2개를 골라
        // 합치는 것을 반복합니다.
        while(pq.size() > 1) {
            int x1 = pq.poll();
            int x2 = pq.poll();

            // 가장 작은 숫자 2개를 더하기 위한 비용을 답에 더해주고,
            // 두 숫자를 합친 결과를 우선순위 큐에 다시 넣어줍니다.
            ans += (x1 + x2);
            pq.add(x1 + x2);
        }

        System.out.print(ans);
    }
}
