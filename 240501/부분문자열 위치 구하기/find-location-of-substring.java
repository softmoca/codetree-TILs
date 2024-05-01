import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 입력받습니다.
        String inputStr = sc.next();
        String targetStr = sc.next();

        // 입력 문자열에서 목적 문자열을 찾는 첫 번째 인덱스를 찾습니다.
        int startIndex = inputStr.indexOf(targetStr);

        // 찾지 못한 경우 -1을 출력합니다.
        if (startIndex == -1) {
            System.out.print(-1);
        } else {
            // 찾은 경우 해당 인덱스를 출력합니다.
            System.out.print(startIndex);
        }
    }
}