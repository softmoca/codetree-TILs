import java.io.*;
import java.util.*;

public class Main {
    static String input;
    static List<Integer> answer = new ArrayList<>();
    static int[] alphArr = new int[128];
    static int res = Integer.MIN_VALUE;

    static int op(int a, int b, char x) {
        if (x == '-') return a - b;
        else if (x == '+') return a + b;
        else return a * b;
    }

    static void cal() {
        int next = alphArr[input.charAt(0)];
        for (int i = 0; i < input.length() - 2; i += 2) {
            next = op(next, alphArr[input.charAt(i + 2)], input.charAt(i + 1));
        }
        res = Math.max(res, next);
    }

    static void choose(int currIdx) {
        if (currIdx == 6) { // 'a' ~ 'f'
            // a~f에 대해 answer 값 적용
            for (int i = 0; i < 6; i++) {
                alphArr['a' + i] = answer.get(i);
            }
            cal();
            return;
        }

        for (int i = 1; i <= 4; i++) {
            answer.add(i);
            choose(currIdx + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        input = sc.next();

        choose(0);
        System.out.println(res);
    }
}