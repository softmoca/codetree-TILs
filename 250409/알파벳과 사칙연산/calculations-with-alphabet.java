import java.util.Scanner;

public class Main {
    static String expr;
    static int max = Integer.MIN_VALUE;
    static int[] values = new int[6]; // 'a' ~ 'f'

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expr = sc.next();
        assignValues(0);
        System.out.println(max);
    }

    // a~f 모든 값 1~4 배정 (DFS)
    static void assignValues(int index) {
        if (index == 6) {
            int result = evaluateExpression();
            max = Math.max(max, result);
            return;
        }

        for (int val = 1; val <= 4; val++) {
            values[index] = val;
            assignValues(index + 1);
        }
    }

    // 왼쪽에서 오른쪽으로 순서대로 계산
    static int evaluateExpression() {
        int result = values[expr.charAt(0) - 'a'];

        for (int i = 1; i < expr.length(); i += 2) {
            char op = expr.charAt(i);
            int nextVal = values[expr.charAt(i + 1) - 'a'];

            if (op == '+') {
                result += nextVal;
            } else if (op == '-') {
                result -= nextVal;
            } else if (op == '*') {
                result *= nextVal;
            }
        }

        return result;
    }
}