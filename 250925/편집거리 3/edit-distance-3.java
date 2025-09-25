import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();


        char[] Arr = new char[A.length() + 1];
        char[] Brr = new char[B.length() + 1];
        for (int i = 1; i < A.length() + 1; i++) {
            Arr[i] = A.charAt(i - 1);
        }
        for (int i = 1; i < B.length() + 1; i++) {
            Brr[i] = B.charAt(i - 1);
        }


        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i < A.length() + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < B.length() + 1; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i < A.length() + 1; i++) {

            for (int j = 1; j < B.length() + 1; j++) {
                if (Arr[i] != Brr[j]) {
                    dp[i][j] = Math.min(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    ) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }


            }
        }
        System.out.println(dp[A.length()][B.length()]);


    }
}

