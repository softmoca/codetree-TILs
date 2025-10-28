import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int windowSum = 0;
        int res = Integer.MAX_VALUE;

        for (int left = 1; left <= n; left++) {
            // 합이 s 미만이면 오른쪽 확장
            while (right + 1 <= n && windowSum < s) {
                right++;
                windowSum += arr[right];
            }

            // 현재 [left, right]가 s 이상이면 길이 갱신
            if (windowSum >= s) {
                res = Math.min(res, right - left + 1);
            }

            // 왼쪽을 한 칸 줄이며 합 갱신
            windowSum -= arr[left];
        }

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
}
