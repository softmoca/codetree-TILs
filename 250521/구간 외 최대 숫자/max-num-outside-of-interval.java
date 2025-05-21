import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] l = new int[n + 1];
        int[] r = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            l[i] = Math.max(arr[i], l[i - 1]);
        }

        for (int i = n; i > 0; i--) {
            r[i] = Math.max(arr[i], r[i + 1]);
        }

        while (q-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(Math.max(l[x - 1], r[y + 1]));
        }


    }
}
