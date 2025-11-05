import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); int K = sc.nextInt();
        int n = s.length(), ans = 0, distinct = 0, l = 0;
        int[] cnt = new int[26];

        for (int r = 0; r < n; r++) {
            if (cnt[s.charAt(r) - 'a']++ == 0) distinct++;     // 새 문자 진입
            while (distinct > K) {                              // K 초과면 왼쪽 축소
                if (--cnt[s.charAt(l++) - 'a'] == 0) distinct--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
    }
}
