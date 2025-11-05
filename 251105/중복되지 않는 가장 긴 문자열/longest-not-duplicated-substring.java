import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int n = word.length();

        Set<Character> set = new HashSet<>();
        int ans = 0;

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && !set.contains(word.charAt(j))) {
                set.add(word.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }
            set.remove(word.charAt(i)); // i를 한 칸 이동하므로 제거
        }

        System.out.println(ans);
    }
}
