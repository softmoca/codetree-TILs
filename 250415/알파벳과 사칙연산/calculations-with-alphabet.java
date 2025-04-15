import java.io.*;
import java.util.*;

public class Main {
    static String input;
    static Set<Character> alphaSet = new HashSet<>();
    static List<Integer> answer = new ArrayList<>();
    static List<Integer> listAlp = new ArrayList<>();
    static int[] alphArr = new int[128];
    static int res = 0;

    static int op(int a, int b, char x) {
        if (x == '-') {
            return a - b;
        } else if (x == '+') {
            return a + b;
        } else if (x == '*') {
            return a * b;
        }

        return 0;
    }

    static void cal() {
        int len = input.length();

        int next = alphArr[input.charAt(0)];
        for (int i = 0; i < len - 2; i += 2) {
            next = op(next, alphArr[input.charAt(i + 2)], input.charAt(i + 1));
        }

        res = Math.max(res, next);

    }


    static void choose(int currIdx) {
        if (currIdx == alphaSet.size()) {

            for (int i = 0; i < alphaSet.size(); i++) {
                alphArr[listAlp.get(i)] = answer.get(i);
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

        for (int i = 0; i < input.length(); i++) {
            if (97 <= input.charAt(i) && input.charAt(i) <= 122) {
                alphaSet.add(input.charAt(i));
            }
        }

        for (int x : alphaSet) {
            listAlp.add(x);
        }


        choose(0);
        System.out.println(res);

    }
}
