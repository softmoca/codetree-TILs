import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static final int MAX_N = 50000;
    
    // 변수 선언
    public static int n;
    public static int[] aCards = new int[MAX_N];
    public static int[] bCards = new int[MAX_N];
    
    public static HashSet<Integer> bSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
            // b 카드 숫자로 이루어진 hashset을 완성해줍니다.
            bSet.add(bCards[i]);
        }
        
        // a 카드를 완성해줍니다.
        int cardIdx = 0;
        for(int i = 1; i <= 2 * n; i++)
            if(!bSet.contains(i))
                aCards[cardIdx++] = i;
            
        // a, b 카드 목록을 전부 오름차순으로 정렬해줍니다.
        Arrays.sort(aCards, 0, n);
        Arrays.sort(bCards, 0, n);
        
        // a의 카드를 작은 숫자부터 보며
        // b카드의 앞에서부터 이길 수 있는 순간에 둘을 매칭하는게 최선임을 이용합니다.
        int ans = 0;
        int bIdx = 0;
        for(int aIdx = 0; aIdx < n; aIdx++) {
            // a가 현재 b 카드보다 우세하다면
            // 둘을 매칭해주는게 항상 유리합니다.
            if(bIdx < n && aCards[aIdx] > bCards[bIdx]) {
                ans++;
                bIdx++;
            }
        }

        System.out.print(ans);
    }
}
