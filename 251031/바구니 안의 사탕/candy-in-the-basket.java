import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] check = new int[4000002];


        for (int i = 0; i < n; i++) {
            int cnt = sc.nextInt();
            int idx = sc.nextInt();
            check[idx] = cnt;
        }

        int p1 = 0;
        int p2 = 2 * k;

        int sum = 0;

        for (int i = 0; i <= 2 * k; i++) {
            sum = sum + check[i];
        }

        int res = sum;

        while (true) {


            p2++;
            if (p2 == 1000001) break;
            sum = sum + check[p2] - check[p1];

            res = Math.max(res, sum);
            p1++;
        }

        System.out.println(res);


    }
}
