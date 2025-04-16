import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[46];

    static int fibo(int x) {

        if (x == 1 || x == 2) {
            return 1;
        }

        if (dp[x] == 0) {
            return dp[x] = fibo(x - 1) + fibo(x - 2);
        } else {
            return dp[x];
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibo(n));


    }
}
