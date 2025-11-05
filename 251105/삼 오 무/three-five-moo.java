import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int l = 1;
        int r = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int target = mid - mid / 3 - mid / 5 + mid / 15;

            if (target < n) {
                l = mid + 1;
            } else if (target > n) {
                r = mid - 1;
            } else {
                System.out.println(mid);
                break;
            }


        }


    }
}

