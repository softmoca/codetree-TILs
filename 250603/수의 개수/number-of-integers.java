import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;

    static int findup(int x) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > x) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);

            } else {
                left = mid + 1;
            }
        }
        return minIdx;

    }

    static int finddown(int x) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);

            } else {
                left = mid + 1;
            }
        }
        return minIdx;

    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        while (m-- > 0) {
            int x = sc.nextInt();
            int a = findup(x);
            int b = finddown(x);
            // System.out.println(a);
            //System.out.println(b);
            if (a == Integer.MAX_VALUE && b != Integer.MAX_VALUE) {
                System.out.println(b);
            } else {
                System.out.println(a - b);

            }


        }


    }
}
