import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        double n;

        // 입력
        n = sc.nextDouble();

        // 출력
        System.out.printf("%.1f", n * 30.48);
    }
}