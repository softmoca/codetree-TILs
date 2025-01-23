import java.util.Scanner;

public class Main {
    public static int x1, y1, x2, y2;
    public static int a1, b1, a2, b2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        x2 = sc.nextInt();
        y2 = sc.nextInt();
        a1 = sc.nextInt();
        b1 = sc.nextInt();
        a2 = sc.nextInt();
        b2 = sc.nextInt();

        // 주어진 값들 중 가장 큰 x에서 가장 작은 x를 뺀 길이가 
        // 세로 길이가 되어야 합니다.
        // 마찬가지 이유로 가장 큰 y에서 가장 작은 y를 뺀 길이가
        // 가로 길이가 되어야 합니다.
        int width = Math.max(x2, a2) - Math.min(x1, a1);
        int height = Math.max(y2, b2) - Math.min(y1, b1);

        System.out.println(width * height);
    }
}
