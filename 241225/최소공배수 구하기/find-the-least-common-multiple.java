import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        // 입력
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 최소공배수 출력
        findLcm(n, m);
    }


  public static void findLcm(int n, int m) {
        int gcd = gcd(n, m); // 최대공약수
        int lcm = (n * m) / gcd; // 최소공배수 공식
        System.out.println(lcm); // 출력
    }


     public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}