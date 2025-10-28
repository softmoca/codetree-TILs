import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n - 1];

        for (int i = 0; i < n - 1; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }


        long[] arr2 = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Long.parseLong(st.nextToken());
        }

        long[] arr3 = new long[n];

        arr3[0] = arr2[0];
        for (int i = 1; i < n - 1; i++) {
            arr3[i] = Math.min(arr2[i], arr3[i - 1]);
        }
        long res = 0;
        for (int i = 0; i < n - 1; i++) {
            res = res + arr[i] * arr3[i];
        }
        System.out.println(res);


    }
}
