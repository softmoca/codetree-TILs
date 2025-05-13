import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        Map<Integer, Integer> map = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            if (!map.containsKey(key)) {
                map.put(key, i + 1);
            }


        }


        for (int x : map.keySet()) {
            System.out.println(x + " " + map.get(x));
        }


    }
}
