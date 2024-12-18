import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 최대 10회 반복합니다.
        for(int i = 0; i < 10; i++) {
            // 문자열을 입력받습니다.
            String str = sc.next();
            
            // str이 END일 경우 종료합니다.
            if(str.equals("END"))
                break;
            
            // 문자열의 길이를 구합니다.
            int len = str.length();
            
            // 문자열을 역으로 출력합니다.
            for(int j = len - 1; j >= 0; j--)
                System.out.print(str.charAt(j));
            System.out.println();
        }
    }
}