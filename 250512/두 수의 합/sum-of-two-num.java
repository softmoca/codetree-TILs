import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], k - arr[i]);

        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(map.get(arr[i]))) {
                res++;
            }


        }
        System.out.println((res + 1) / 2);


    }
}
