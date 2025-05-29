import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static String word;
    public static HashMap<Character, Integer> countArray = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        word = sc.next();
        n = word.length();
        
        word = "#" + word;

        // 가능한 구간 중 최대 크기를 구합니다.
        int ans = 0;
        
        // 구간을 잡아봅니다.
        int j = 0;
        for(int i = 1; i <= n; i++) {
            // 같은 문자가 2개가 되기 전까지 계속 진행합니다.
            while(j + 1 <= n && countArray.getOrDefault(word.charAt(j + 1), 0) != 1) {
                char c = word.charAt(j + 1);
                countArray.put(c, countArray.getOrDefault(c, 0) + 1);
                j++;
            }
            
            // 현재 구간 [i, j]는 
            // i를 시작점으로 하는
            // 가장 긴 구간이므로
            // 구간 크기 중 최댓값을 갱신합니다.
            ans = Math.max(ans, j - i + 1);

            // 다음 구간으로 넘어가기 전에
            // word[i]에 해당하는 값은 countArray에서 지워줍니다.
            countArray.put(word.charAt(i), countArray.get(word.charAt(i)) - 1);
        }

        System.out.print(ans);
    }
}
