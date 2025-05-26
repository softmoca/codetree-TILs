import java.util.Scanner;
import java.util.Arrays;

class Candy implements Comparable<Candy> {
    int x, cnt;

    public Candy(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Candy c) {
        return this.x - c.x; // 위치 기준 오름차순 정렬
    }
}

public class Main {
    public static final int MAX_N = 100000;
    public static Candy[] candies = new Candy[MAX_N + 1];
    public static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int cnt = sc.nextInt();
            int x = sc.nextInt();
            candies[i] = new Candy(x, cnt);
        }

        // 위치 기준 정렬
        Arrays.sort(candies, 1, n + 1);

        // 슬라이딩 윈도우
        int p1 = 1, p2 = 1;
        int sum = 0;
        int ans = 0;

        while (p2 <= n) {
            // 윈도우 오른쪽 확장: [candies[p1].x, candies[p2].x] ≤ 2k 범위
            if (candies[p2].x - candies[p1].x <= 2 * k) {
                sum += candies[p2].cnt;
                ans = Math.max(ans, sum);
                p2++;
            } else {
                // 왼쪽 윈도우 수축
                sum -= candies[p1].cnt;
                p1++;
            }
        }

        System.out.println(ans);
    }
}