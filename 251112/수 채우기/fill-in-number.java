import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1 || n == 3) {
            System.out.println(-1);
        } else {

            int res = 0;

            res = n / 5;
            n = n % 5;

            if (n % 2 == 0) {
                res = res + n / 2;
            } else {
                res--;
                res = res + (n + 5) / 2;

            }
            System.out.println(res);


        }


    }
}
