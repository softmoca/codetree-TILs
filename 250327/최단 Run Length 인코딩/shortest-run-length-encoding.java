import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    static int count(char[] chars) {
        int cnt = 1;
        int len = chars.length;

        for (int i = 0; i < len - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                cnt++;
            }

        }

        if (cnt == 1 && len == 10) {
            return 3;
        }

        return cnt * 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int len = str.length();
        int res = 10000;
        char[] chars = str.toCharArray();

        while (len-- >= 0) {

            // 쉬프트

            ArrayDeque<Character> ad = new ArrayDeque<>();
            for (int i = 1; i < len; i++) {
                ad.addLast(chars[i]);
            }
            ad.addLast(chars[0]);

            for (int i = 0; i < len; i++) {
                chars[i] = ad.removeFirst();
            }

            // run legnth길이 구하기
            res = Math.min(res, count(chars));


        }
        System.out.println(res);

    }

    static int n;

    static void initArray(Scanner sc, int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }

    static void printArray(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
