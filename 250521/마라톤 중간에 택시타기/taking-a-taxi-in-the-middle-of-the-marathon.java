import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        int[] l = new int[n + 1];
        int[] r = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        for (int i = 2; i <= n; i++) {
            l[i] = l[i - 1] + Math.abs(x[i] - x[i - 1]) + Math.abs(y[i] - y[i - 1]);
        }

        for (int i = n - 1; i > 0; i--) {
            r[i] = r[i + 1] + Math.abs(x[i] - x[i + 1]) + Math.abs(y[i] - y[i + 1]);
        }

        System.out.println();

        int res = Integer.MAX_VALUE;

        for (int i = 2; i < n; i++) {

            res = Math.min(res,
                    l[i - 1] + r[i + 1] + Math.abs(x[i - 1] - x[i + 1]) + Math.abs(y[i - 1] - y[i + 1])

            );


        }

        System.out.println(res);


    }
}
