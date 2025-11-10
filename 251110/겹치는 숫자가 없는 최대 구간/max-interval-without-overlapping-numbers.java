import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 현재 구간 내 등장한 수를 기록할 Map (또는 boolean 배열도 가능)
        Map<Integer, Integer> count = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < N; right++) {
            int num = arr[right];
            count.put(num, count.getOrDefault(num, 0) + 1);

            // 중복이 생기면 left를 옮겨 중복 제거
            while (count.get(num) > 1) {
                int leftNum = arr[left];
                count.put(leftNum, count.get(leftNum) - 1);
                left++;
            }

            // 중복이 없는 상태에서 길이 갱신
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
