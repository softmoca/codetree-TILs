import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] count = new int[100001];
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int j = 0;
        int res = -1;
        for (int i = 1; i <= n; i++) {

            while (j + 1 <= n && count[arr[j + 1]] != 1) {
                count[arr[j + 1]]++;
                j++;

            }


            res = Math.max(res, j - i + 1);
            count[arr[i]]--;

        }

        System.out.println(res);

    }
}
