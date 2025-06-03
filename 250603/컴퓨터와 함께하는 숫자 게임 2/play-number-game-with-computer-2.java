import java.io.*;
import java.util.*;

public class Main {

    static int m;

    static int find(int target) {
        int left = 1;
        int right = m;
        int cnt = 0;
        while (left <= right) {
            cnt++;
            int mid = left + (right - left) / 2;
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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int mmax = Integer.MIN_VALUE;
        int minx = Integer.MAX_VALUE;
        for (int i = a; i <= b; i++) {

            int cnt = find(i);
            mmax = Math.max(mmax, cnt);
            minx = Math.min(minx, cnt);


        }
        System.out.println(minx + " " + mmax);

    }
}
