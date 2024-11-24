import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열을 정의합니다.
        String a;
        String b;
        String str1;
        String str2;
        
        // 문자열을 입력받습니다.
        a = sc.next();
        b = sc.next();

        // 문자열의 길이를 구합니다.
	    int lenA = a.length();
	    int lenB = b.length();

        int idx1 = 0;
	    int idx2 = 0;

        // a의 정수로 변환 가능한 최대 인덱스를 찾습니다.
        for(int i = 0; i < lenA; i++)
            if(a.charAt(i) <= '9' && a.charAt(i) >= '0')
                idx1++;
            else break;
        
        // b의 정수로 변환 가능한 최대 인덱스를 찾습니다.
        for(int i = 0; i < lenB; i++)
            if(b.charAt(i) <= '9' && b.charAt(i) >= '0')
                idx2++;
            else break;
        
        // a의 정수로 변환 가능한 부분을 다른 문자열로 옮깁니다.
        str1 = a.substring(0, idx1);
        
        // b의 정수로 변환 가능한 부분을 다른 문자열로 옮깁니다.
        str2 = b.substring(0, idx2);
        
        // 합쳐진 문자열을 숫자로 바꿉니다.
        int str1Int = Integer.parseInt(str1);
        int str2Int = Integer.parseInt(str2);
        
        // 두 숫자의 합을 출력합니다.
        System.out.print(str1Int + str2Int);
    }
}