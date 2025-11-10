import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 한 줄에 문자열과 K가 공백으로 주어짐 (예: "ababab 2")
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        int n = s.length();
        int[] cnt = new int[26];   // 알파벳 빈도
        int distinct = 0;          // 현재 윈도우 내 서로 다른 문자 수
        int maxLen = 0;
        int left = 0;

        // [left, right] 윈도우 유지
        for (int right = 0; right < n; right++) {
            int r = s.charAt(right) - 'a';
            if (cnt[r] == 0) distinct++;
            cnt[r]++;

            // 서로 다른 문자가 K를 넘으면 왼쪽을 줄여서 조건 회복
            while (distinct > K) {
                int l = s.charAt(left) - 'a';
                cnt[l]--;
                if (cnt[l] == 0) distinct--;
                left++;
            }

            // 현재 윈도우는 항상 distinct <= K
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
