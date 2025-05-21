import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = new char[n + 1];
        int[] hl = new int[n + 1];
        int[] sl = new int[n + 1];
        int[] pl = new int[n + 1];
        int[] hr = new int[n + 2];
        int[] sr = new int[n + 2];
        int[] pr = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.next().charAt(0);
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 'S') {
                hl[i] = hl[i - 1] + 1;
            } else {
                hl[i] = hl[i - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 'P') {
                sl[i] = sl[i - 1] + 1;
            } else {
                sl[i] = sl[i - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 'H') {
                pl[i] = pl[i - 1] + 1;
            } else {
                pl[i] = pl[i - 1];
            }
        }


        for (int i = n; i > 0; i--) {
            if (arr[i] == 'S') {
                hr[i] = hr[i + 1] + 1;
            } else {
                hr[i] = hr[i + 1];
            }
        }
        for (int i = n; i > 0; i--) {
            if (arr[i] == 'P') {
                sr[i] = sr[i + 1] + 1;
            } else {
                sr[i] = sr[i + 1];
            }
        }
        for (int i = n; i > 0; i--) {
            if (arr[i] == 'H') {
                pr[i] = pr[i + 1] + 1;
            } else {
                pr[i] = pr[i + 1];
            }
        }


        int res = Integer.MIN_VALUE;


        for (int i = 0; i <= n; i++) {
            res = Math.max(res,

                    Math.max(hl[i], Math.max(sl[i], pl[i])) +
                            Math.max(hr[i + 1], Math.max(sr[i + 1], pr[i + 1]))

            );

        }
        System.out.println(res);


    }
}
