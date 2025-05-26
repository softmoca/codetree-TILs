import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);

        int p1 = 1;
        int p2 = 2;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.min(res, Math.abs(arr[p1] + arr[p2]));
            p1++;
            p2++;


        }
        System.out.println(res);


    }
}
