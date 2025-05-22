import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[200001];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x] = 1;

            arr[y] = -1;
        }

        int sum = 0;

        int res = 0;
        for (int i = 0; i < 200001; i++) {
            sum += arr[i];

            res = Math.max(res, sum);

        }

        System.out.println(res);

    }
}
