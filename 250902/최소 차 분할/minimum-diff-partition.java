import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int len = sum / 2;
        boolean[] visited = new boolean[len + 1];

        visited[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = len; j >= 0; j--) {
                if (j - arr[i] >= 0 && visited[j - arr[i]]) {
                    visited[j] = true;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= len; i++) {
            if (visited[i]) {
                res = Math.min(res, sum - i);
            }
        }


        System.out.println(Math.abs(sum-res*2));


    }
}
