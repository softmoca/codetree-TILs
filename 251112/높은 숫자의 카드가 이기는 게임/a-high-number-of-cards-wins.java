import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= 2 * n; i++) {
            set.add(i);
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            set.remove(x);
        }


        int res = 0;

        for (int i = 0; i < n; i++) {
            Integer target = set.higher(arr[i]);
            if (target != null) {
                res++;
                set.remove(target);
            }
        }
        System.out.println(res);


    }
}
