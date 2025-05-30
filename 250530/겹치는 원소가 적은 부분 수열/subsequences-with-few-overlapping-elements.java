import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, k;
    public static int[] arr = new int[MAX_N + 1];
    
    // map을 이용하여 같은 원소가 몇개 들어있는지 확인합니다.
    public static HashMap<Integer, Integer> countArray = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        
        // 조건을 만족하는 가장 긴 구간의 길이를 구합니다.
        int ans = 0;

        // 구간을 잡아봅니다.
        int j = 0;
        for(int i = 1; i <= n; i++) {
            // 구간에 k개 초과하여 겹치는 원소가 없다면 계속 진행합니다.
            while(j + 1 <= n && countArray.getOrDefault(arr[j + 1], 0) < k) {
                countArray.put(arr[j + 1], countArray.getOrDefault(arr[j + 1], 0) + 1);
                j++;
            }

            // 현재 구간 [i, j]는 
            // i를 시작점으로 하는
            // 가장 긴 구간이므로
            // 구간 크기 중 최댓값을 갱신합니다.
            ans = Math.max(ans, j - i + 1);

            // 다음 구간으로 넘어가기 전에
            // arr[i]에 해당하는 값은 구간에서 제외시킵니다.
            countArray.put(arr[i], countArray.get(arr[i]) - 1);
        }

        // 정답을 출력합니다.
        System.out.print(ans);
    }
}
