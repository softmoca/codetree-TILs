import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[100001];

        int right = 0;
        int res = Integer.MIN_VALUE;
        for (int left = 1; left <= n; left++) {
            while (right  < n && check[arr[right + 1]] == 0) {
                right++;
                check[arr[right]]++;
            }

            res = Math.max(res, right - left + 1);
            check[arr[left]]--;
        }

        System.out.println(res);


    }
}
