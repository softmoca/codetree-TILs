import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 숫자를 입력받습니다.
        int n = sc.nextInt();
        
        // 문자열을 입력받습니다.
        String str = sc.next();
        
        int cnt = 0;
        
        // 입력받는 문자열이 str과 같은 것의 개수를 확인합니다.
        for(int i = 0; i < n; i++) {
            // 문자열을 입력받습니다.
            String str2 = sc.next();
            
            // 문자열이 str과 같을 경우 cnt를 1 더해줍니다.
            if(str.equals(str2))
                cnt++;
        }
        
        // 각 자리 숫자의 합을 출력합니다.
        System.out.println(cnt);
    }
}