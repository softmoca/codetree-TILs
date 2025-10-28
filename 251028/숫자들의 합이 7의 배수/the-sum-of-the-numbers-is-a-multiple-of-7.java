import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        // prefix[0] = 0 으로 시작
        int res = 0, prefix = 0;
        int[] first = new int[7];
        Arrays.fill(first, -1);
        first[0] = 0; // 누적합이 0인 경우(처음부터의 구간) 대비

        for (int i = 1; i <= n; i++) {
            prefix = (prefix + arr[i - 1]) % 7;
            if (first[prefix] == -1) {
                first[prefix] = i;           // 이 나머지의 첫 등장 인덱스 저장
            } else {
                res = Math.max(res, i - first[prefix]); // 최대 길이 갱신
            }
        }

        System.out.println(res);
    }
}
