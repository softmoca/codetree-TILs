import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        s = "K" + s;
        char[] c = s.toCharArray();

        int[] cl = new int[n + 1];
        int[] wr = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            if (c[i] == 'C') {
                cl[i] = cl[i - 1] + 1;
            } else {
                cl[i] = cl[i - 1];
            }

        }

        for (int i = n; i > 0; i--) {
            if (c[i] == 'W') {
                wr[i] = wr[i + 1] + 1;
            } else {
                wr[i] = wr[i + 1];
            }

        }


        long res = 0;

        for (int i = 2; i < n; i++) {
            if (c[i] == 'O') {
                res += cl[i] * wr[i];
            }

        }


        System.out.println(res);


    }
}
