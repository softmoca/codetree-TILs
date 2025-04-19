import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {

            for (int j = m; j >= 0; j--) {
                if (arr[i] <= j) {

                    if (dp[j - arr[i]]) {
                        dp[j] = true;
                    }


                }


            }


        }
        if (dp[m]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
