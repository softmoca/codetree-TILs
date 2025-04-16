import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static List<Integer> answer = new ArrayList<>();

    static void choose(int currIdx, int startIdx) {
        if (currIdx == m) {
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = startIdx; i <= n; i++) {

            if(  n-i +1  <m-currIdx  ) continue;

            answer.add(i);
            choose(currIdx + 1, i + 1);
            answer.remove(answer.size() - 1);
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        choose(0, 1);

    }
}
