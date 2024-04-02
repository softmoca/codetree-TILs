import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // b가 a보다 크고 c보다 작다면 1, 그렇지 않다면 0을 출력
        int result = (b > a && b < c) ? 1 : 0;
        System.out.println(result);
    }
}