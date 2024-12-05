import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 숫자를 입력받습니다.
        int a = sc.nextInt();
        String aStr;
        int cnt = 0;

        // 숫자를 문자열로 바꿉니다.
        aStr = Integer.toString(a);
        
        // 문자열의 길이를 구합니다.
        int len = aStr.length();
        
        // 문자열에서 각 자리 숫자들의 합을 구합니다.
        for(int i = 0; i < len; i++)
            cnt += aStr.charAt(i) - '0';
        
        // 각 자리 숫자의 합을 출력합니다.
        System.out.print(cnt);
    }
}