import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }


        int j = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {

            while (j + 1 <= n && arr[j + 1] + sum <= s) {
                j++;
                sum += arr[j];
            }

            if (sum >= 15) {
                res = Math.min(res, j - i + 1);
            }
       //     System.out.println(j + " " + i + " " + sum);


            sum -= arr[i];

        }

        System.out.println(res);


    }


}

