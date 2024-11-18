import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자와 숫자를 입력받습니다.
        char x = sc.next().charAt(0);
        int a = sc.nextInt();

        // 문자의 아스키코드값과 숫자 아스키코드 번호에 해당하는 문자값을 출력합니다.
        System.out.print((int)x + " " + (char)a);
    }
}