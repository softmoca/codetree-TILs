import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[4000006];

        int sum = 0;


        while (n-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[y] = arr[y] + x;
        }

        for (int i = 1; i <= 2 * k + 1; i++) {
            sum += arr[i];
        }
        int p1 = 1;
        int p2 = 2 * k + 2;
        int res = sum;
        while (true) {
            if (p2 == 4000006) break;

            // System.out.println(p1 + " " + p2);

            sum = sum + arr[p2++] - arr[p1++];
            //   System.out.println(sum);
            res = Math.max(res, sum);


        }
        System.out.println(res);


    }
}
