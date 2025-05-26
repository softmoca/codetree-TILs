import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] arr2 = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            arr2[i] = sc.nextInt();
        }


        int p1 = 1, p2 = 1;

        while (p1 <= n && p2 <= m) {
            if (arr[p1] == arr2[p2]) {
                p1++;
                p2++;
            } else {
                p1++;
            }
        }

// 종료 조건 확인
        if (p2 == m + 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }
}
