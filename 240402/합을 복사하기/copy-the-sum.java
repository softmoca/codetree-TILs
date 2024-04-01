public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;

        // 세 정수의 합을 계산합니다.
        int sum = a + b + c;

        // 각 변수에 합을 저장합니다.
        a = sum;
        b = sum;
        c = sum;

        // 각 변수의 값을 출력합니다.
        System.out.printf("%d %d %d",a,b,c);

    }
}