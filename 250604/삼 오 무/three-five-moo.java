import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        long n = 10000000000L;
        long cnt = 0;
        for (long i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0) continue;
            cnt++;
            if (cnt == x) {
                System.out.println(i);
                break;
            }


        }
    }
}
