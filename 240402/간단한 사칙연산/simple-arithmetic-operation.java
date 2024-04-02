import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 두 정수를 더했을 때의 결과
        int sum = a + b;

        // a에서 b를 뺐을 때의 결과
        int diff = a - b;

        // a를 b로 나누었을 때의 몫
        int quotient = a / b;

        // a를 b로 나누었을 때의 나머지
        int remainder = a % b;

        // 결과 출력
        System.out.println(sum);
        System.out.println(diff);
        System.out.println(quotient);
        System.out.println(remainder);
    }
}