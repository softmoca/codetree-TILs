import java.io.*;
import java.util.*;

public class Main {

    static long m;

    static int find(long target) {
        long left = 1;
        long right = m;
        int cnt = 0;
        while (left <= right) {
            cnt++;
            long mid = left + (right - left) / 2;
            if (mid == target) {
                return cnt;
            } else if (mid > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();
        long mmax = Long.MIN_VALUE;
        long minx = Long.MAX_VALUE;
        for (long i = a; i <= b; i++) {

            int cnt = find(i);
            mmax = Math.max(mmax, cnt);
            minx = Math.min(minx, cnt);


        }
        System.out.println(minx + " " + mmax);

    }
}
