import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static boolean isOk(int currIdx, int newNum) {
        answer.add(newNum);
        int tempnum = (currIdx + 1) / 2;


        for (int i = 1; i <= tempnum; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (answer.get(currIdx - j) != answer.get(currIdx - i - j)) {
                    flag = true;
                }
            }
            if (!flag) {
                answer.remove(answer.size() - 1);
                return false;

            }
        }

        return true;
    }

    static List<Integer> answer = new ArrayList<>();

    static void choose(int currIdx) {
        if (currIdx == n) {
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i));
            }
            System.exit(0);
            System.out.println();
            return;
        }
        for (int i = 4; i < 7; i++) {


            if (isOk(currIdx, i)) {
                choose(currIdx + 1);
                answer.remove(answer.size() - 1);
            }

        }


    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        choose(0);

    }
}