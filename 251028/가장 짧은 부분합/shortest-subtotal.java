import java.io.*;
import java.util.*; /* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1]; // 1-indexed
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int windowSum = 0;
        int res = Integer.MAX_VALUE;

        for (int left = 1; left <= n; left++) {
            // 이 while은 그대로 유지!
            while (right + 1 <= n && windowSum + arr[right + 1] < s) {
                windowSum += arr[right + 1];
                right++;
            }

            // 다음 원소 하나를 더하면 s 이상이 되는지 '가상 포함'으로 확인
            if (right + 1 <= n && windowSum + arr[right + 1] >= s) {
                // 길이는 (right+1) - left + 1 == right - left + 2
                res = Math.min(res, right - left + 2);
            }

            // 왼쪽을 한 칸 줄이며 합 갱신
            windowSum -= arr[left];
        }

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
}
