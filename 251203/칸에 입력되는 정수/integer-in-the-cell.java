import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine());

            boolean flag = false;

            for (int j = x; j >= 1; j--) {
                if (arr[j] == 0) {
                    arr[j] = x;
                    flag = true;
                    break;
                }
            }

            if (!flag) break;
            res++;


        }

        System.out.println(res);

    }
}
