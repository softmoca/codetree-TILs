import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 전화번호 입력 받기

        String phoneNumber = sc.nextLine();

        // 앞 4자리와 뒤 4자리 추출
        String front = phoneNumber.substring(4, 8);
        String back = phoneNumber.substring(8);

        // 바뀐 전화번호 출력
        System.out.println("010" + back + "-" + front);
    }
}