import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, k;
    public static String word;
    public static HashMap<Character, Integer> countArray = new HashMap<>();
    
    public static int ans;             // 가능한 구간 중 최대 크기를 저장해줍니다.
    public static int distinctNumber; // 서로 다른 문자의 수를 저장해줍니다.
    
    // j가 추가적으로 더 앞으로 움직여도 되는지 판단합니다.
    public static boolean canMove(int j) {
        // 범위를 벗어난다면 움직일 수 없습니다.
        if(j + 1 > n)
            return false;
        
        // 이미 서로 다른 문자의 개수가 k개인데
        // 또 새로운 문자를 추가하는 것이라면
        // 더 움직일 수 없습니다.    
        if(distinctNumber == k && countArray.getOrDefault(word.charAt(j + 1), 0) == 0)
            return false;
        
        // 이외에는 움직여도 됩니다.
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        word = sc.next();
        k = sc.nextInt();
        n = word.length();
        word = "#" + word;
        
        // 구간을 잡아봅니다.
        distinctNumber = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            // 서로 다른 문자의 수가 k개가 넘기 전까지 계속 진행합니다.
            while(canMove(j)) {
                char c = word.charAt(j + 1);
                countArray.put(c, countArray.getOrDefault(c, 0) + 1);
                // 새로운 문자가 추가된 것이라면, 서로 다른 문자의 수를 늘려줍니다.
                if(countArray.getOrDefault(c, 0) == 1)
                    distinctNumber++;
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

            // 해당 문자가 사라졌다면, 서로 다른 문자의 수를 하나 줄여줍니다.
            if(countArray.get(word.charAt(i)) == 0)
                distinctNumber--;
        }

        System.out.print(ans);
    }
}
