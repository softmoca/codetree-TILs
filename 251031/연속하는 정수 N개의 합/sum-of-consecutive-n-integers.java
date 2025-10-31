import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int p1 = 1;
        int p2 = 1;
        int sum = arr[1];
        int cnt = 0;
        while (true) {
            if (sum == m) {
                cnt++;
                if (p1 == n) break;
                sum -= arr[p1++];

            } else if (sum < m) {
                if (p2 == n) break;
                sum += arr[++p2];
            } else if (sum > m) {
                if (p1 == n) break;
                sum -= arr[p1++];
            }
        }
        System.out.println(cnt);


    }
}
