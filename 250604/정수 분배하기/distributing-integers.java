import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int maxx = Integer.MIN_VALUE;

    static boolean isPossible(int target) {

        int cnt = 0;


        for (int i = 0; i < n; i++) {

            if (arr[i] / target == 0) return false;

            cnt += arr[i] / target;

        }


        return cnt >= m;

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            maxx = Math.max(maxx, arr[i]);
        }


        int left = 1;
        int right = maxx;

        int resMax = Integer.MIN_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(mid)) {
                left = mid + 1;
                resMax = Math.max(resMax, mid);
            } else {
                right = mid - 1;
            }

        }
        System.out.println(resMax);


    }
}
