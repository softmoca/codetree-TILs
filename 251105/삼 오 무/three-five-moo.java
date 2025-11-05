import java.io.*;
import java.util.*;

public class Main {
    static long count(long k) { // 1..k 중 3·5의 배수가 아닌 수의 개수
        return k - k/3 - k/5 + k/15;
    }
    public static void main(String[] args) throws Exception {
        long N = new Scanner(System.in).nextLong();
        long lo = 1, hi = 2*N;              // 밀도≈8/15 → 2N이면 충분
        while (lo < hi) {
            long mid = (lo + hi) >>> 1;
            if (count(mid) >= N) hi = mid;  // N개 이상이면 왼쪽으로
            else lo = mid + 1;              // 부족하면 오른쪽으로
        }
        System.out.println(lo);             // lo가 N번째에 적히는 수
    }
}
