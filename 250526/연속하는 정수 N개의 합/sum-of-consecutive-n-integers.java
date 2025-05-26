import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int p1 = 1, p2 = 0;
        int sum = arr[p1];
        int res = 0;
        while (true) {
            if (sum == m) {
                res++;
                p1++;
                sum += arr[p1];
            } else if (sum < m) {
                p1++;
                sum += arr[p1];
            } else {
                p2++;
                sum -= arr[p2];
            }

            if (p1 == n + 1) break;
            if (p2 > p1) break;


        }
        System.out.println(res);


    }
}
