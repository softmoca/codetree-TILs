import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
      

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            set.add(arr1[i]);
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();

            if (set.contains(x)) {
                res[i] = 1;
            }
            

        }


        for (int i = 0; i < m; i++) {
            System.out.print(res[i]+" ");
        }


    }
}
