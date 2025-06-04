import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong();

        long left = 1;
        long right = (long) Math.pow(10, 18);
        long res = Long.MIN_VALUE;
        while (left <= right) {

            long mid = left + (right - left) / 2;

            if ((double) mid * (mid + 1) / 2 <= s) {
                left = mid + 1;
                res = Math.max(res, mid);

            } else {
                right = mid - 1;
            }


        }
        System.out.println(res);


    }
}
