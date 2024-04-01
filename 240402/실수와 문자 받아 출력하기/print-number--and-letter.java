import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        String a;
        double b, c;

        // 입력
        a = sc.next();

        b = sc.nextDouble();
        c = sc.nextDouble();

        // 출력
        System.out.println(a);
        System.out.printf("%.2f\n%.2f", b, c);
    }
}