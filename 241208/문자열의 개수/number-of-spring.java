import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열 배열을 구현합니다.
        String[] str = new String[201];
        int cnt = 0;

        // 0이 나올때까지 반복합니다.
        while(true) {
            // 문자열을 입력받습니다.
            str[cnt] = sc.next();
            
            // 0이 나올 경우 while문을 빠져나옵니다.
            if(str[cnt].equals("0"))
                break;
            
            cnt++;
        }

        // 문자열의 개수를 출력합니다.
        System.out.println(cnt);
        
        // 홀수 번째 문자열을 출력합니다.
        for(int i = 0; i < cnt; i += 2)
            System.out.println(str[i]);
    }
}