import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int p1 = 0;
        int p2 = 1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 2; i++) {
            res = Math.min(res, Math.abs(arr[p1] + arr[p2]));
            p1++;
            p2++;


        }
        System.out.println(res);


    }
}
