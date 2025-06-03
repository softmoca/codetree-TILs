import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    static int find(int x) {

        int idx = -1;

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                idx = mid + 1;
                break;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            }
        }


        return idx;

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        while (m-- > 0) {
            int x = sc.nextInt();

            int res = find(x);

            System.out.println(res);

        }


    }
}
