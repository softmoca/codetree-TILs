import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        long count = 0;
        int left = 0, sum = 0;

        // 오른쪽 포인터를 for문으로 이동
        for (int right = 0; right < N; right++) {
            sum += A[right];  // 오른쪽 값을 더함

            // sum이 M 이상이면, 왼쪽을 줄여가며 검사
            while (sum >= M) {
                if (sum == M) count++;  // 정확히 M일 때 경우의 수 추가
                sum -= A[left++];       // 왼쪽 포인터 이동
            }
        }

        System.out.println(count);
    }
}
