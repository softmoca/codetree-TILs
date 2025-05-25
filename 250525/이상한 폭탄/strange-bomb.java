import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 200000;
    
    // 변수 선언
    public static int n, k;
    public static int[] arr = new int[MAX_N];
    public static int[] R = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // R 배열을 채워줍니다.
        // Ri = i + 1번째부터 N번째 까지 있는 숫자들 중
        // arr[i]와 숫자가 같은 폭탄 중
        // 가장 가까이에 있는 폭탄의 index
        // 만약 그러한 폭탄이 없다면 -1을 넣어줍니다.

        // 이때 각 숫자별(key)로 가장 가까이에 있는 위치(value)를
        // 바로 찾아내기 위해 hashmap을 사용합니다.
        HashMap<Integer, Integer> latestIndex = new HashMap<>(); 
        for(int i = n - 1; i >= 0; i--) {
            // latestIndex에 arr[i]가 존재하지 않는다면
            // 최초로 나온 숫자이므로 -1을 넣어줍니다.
            if(!latestIndex.containsKey(arr[i]))
                R[i] = -1;
            // 이미 arr[i]가 나온적이 있다면
            // 최근에 나온 index를 latestIndex에서 찾아 넣어줍니다.
            else
                R[i] = latestIndex.get(arr[i]);

            // arr[i]가 가장 최근에 등장한 index의 위치를
            // i로 갱신해줍니다.
            latestIndex.put(arr[i], i);
        }
        
        // 답을 구해줍니다.
        // 현재 위치 i에 대해
        // 오른쪽에 있으면서 가장 가까이에 있는 동일한 숫자 위치를 구해
        // K 이내에 있는지를 확인하고
        // 그런 경우에 한하여 번호 중 최댓값을 갱신합니다.
        int ans = -1;
        for(int i = 0; i < n; i++) {
            // R[i]가 -1이 아니면서
            // R[i]와 i와의 차이가 K 이하 라면
            // arr[i]는 답의 후보가 됩니다.
            if(R[i] != -1 && R[i] - i <= k)
                ans = Math.max(ans, arr[i]);
        }

        System.out.print(ans);
    }
}
