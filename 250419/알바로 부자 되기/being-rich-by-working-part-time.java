import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int start, end, point;

        Pair(int start, int end, int point) {
            this.start = start;
            this.end = end;
            this.point = point;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n];
        Pair[] pais = new Pair[n];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int point = sc.nextInt();
            pais[i] = new Pair(start, end, point);
        }

        Arrays.sort(pais,
                Comparator.comparing((Pair pair) -> pair.start)
        );

        for (int i = 0; i < n; i++) {
            dp[i] = pais[i].point;

            for (int j = 0; j < i; j++) {
                int startI = pais[i].start;
                int endJ = pais[j].end;
                if (startI > endJ) {
                    dp[i] = Math.max(dp[i], dp[i] + dp[j]);
                }

            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            res = Math.max(dp[i], res);

        }
        System.out.println(res);

    }
}
