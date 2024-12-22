import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 나눗셈 결과 저장
        StringBuilder result = new StringBuilder();

        // 정수부 계산
        int quotient = a / b;
        result.append(quotient).append(".");

        // 나머지 계산
        int remainder = a % b;

        // 소수점 아래 21자리 계산
        for (int i = 0; i < 20; i++) {
            remainder *= 10;              // 나머지를 10배 증가
            int digit = remainder / b;   // 현재 자리 값
            result.append(digit);        // 결과에 추가
            remainder %= b;              // 새로운 나머지 계산
        }

        // 결과 출력
        System.out.println(result);
    }
}
