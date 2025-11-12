import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // N개의 가격을 공백 기준으로 읽기 (줄바꿈에 상관없이)
        long[] price = new long[N];
        int idx = 0;
        while (idx < N) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && idx < N) {
                price[idx++] = Long.parseLong(st.nextToken());
            }
        }

        long minSoFar = Long.MAX_VALUE; // 지금까지 최저 매수가
        long maxProfit = 0;             // 최대 이익

        for (int i = 0; i < N; i++) {
            minSoFar = Math.min(minSoFar, price[i]);         // 매수 최저가 갱신
            maxProfit = Math.max(maxProfit, price[i] - minSoFar); // 현재 팔면 이익
        }

        System.out.println(maxProfit); // 이익이 없으면 0
    }
}
