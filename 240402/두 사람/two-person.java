import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 사람의 정보 입력
        int age1 = sc.nextInt();
        String gender1 = sc.next();

        // 두 번째 사람의 정보 입력
        int age2 = sc.nextInt();
        String gender2 = sc.next();

        // 두 사람 중 한 사람이라도 19세 이상 남성인지 확인
        boolean isAdultMale = (age1 >= 19 && gender1.equals("M")) || (age2 >= 19 && gender2.equals("M"));

        // 결과 출력
        System.out.println(isAdultMale ? 1 : 0);
    }
}