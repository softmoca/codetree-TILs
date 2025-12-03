import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[] arr = new int[n + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aa = arr[a];
            int bb = arr[b];


            if (aa == 0 && bb == 0) {
                arr[a] = -1;
                arr[b] = 1;

            } else if (aa == 1 && bb == 0) {
                arr[b] = -1;

            } else if (aa == 0 && bb == 1) {
                arr[a] = -1;

            } else if (aa == -1 && bb == 0) {
                arr[b] = 1;
            } else if (aa == 0 && bb == -1) {
                arr[a] = 1;
            } else if (aa == 1 && bb == 1) {
                System.out.println(0);
                System.exit(0);
            } else if (aa == -1 && bb == -1) {
                System.out.println(0);
                System.exit(0);
            }


        }
        System.out.println(1);

    }
}
