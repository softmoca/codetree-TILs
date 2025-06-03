import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] arr;

    static int find(int target) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);


            } else {
                left = mid + 1;
            }
        }

        return minIdx;
    }


    static int find2(int target) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
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
            int res = find(x);
            int res1 = find2(x);

          //  System.out.println(res + " " + res1);

            if (res1 - res == 0) {
                System.out.println(-1);
            } else {
                System.out.println(res + 1);
            }


        }


    }
}
