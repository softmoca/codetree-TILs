import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        long[] arr = new long[N];

        int filled = 0;
        while (filled < N) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) arr[filled++] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long minAbsSum = Long.MAX_VALUE;  // |합|의 최소값
        int left = 0;

        for (int right = N - 1; right > left; ) {
            long sum = arr[left] + arr[right];
            long absSum = Math.abs(sum);

            if (absSum < minAbsSum) {
                minAbsSum = absSum;
            }

            // 합이 양수면 줄이고, 음수면 늘린다
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                // 0이면 더 이상 갱신 불필요
                minAbsSum = 0;
                break;
            }
        }

        System.out.println(minAbsSum);
    }
}
