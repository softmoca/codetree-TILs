import java.io.*;
import java.util.*;

/*

 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            B[i] = sc.nextInt();
        }

        int p1 = 1;
        int p2 = 1;

        boolean flag = false;
        while (true) {

            if (A[p1] == B[p2]) {
                p1++;
                p2++;
                if (p2 == m + 1) {
                    flag = true;
                    break;
                }
            } else {
                p1++;
            }
            if (p1 == n + 1) {
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }
}
