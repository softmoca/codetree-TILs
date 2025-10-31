import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 1;
        int right = 1;
        int sum = 0;

        int res = Integer.MAX_VALUE;
        A:
        while (true) {

            while (true) {
                sum = sum + arr[right];
                if (sum >= s) {

                    break;
                }

                right++;
                if (right == n + 1) {

                    break A;
                }

            }


            if (sum >= s) {
                res = Math.min(res, right - left + 1);
            }

            sum -= arr[left];
            sum -= arr[right];
            left++;
            if (left == n + 1) break;


        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }

    }
}
