import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int k;
    static int[] scores;
    static List<Integer> answer = new ArrayList<>();
    static int[] dis;
    static int res = 0;

    static void cal() {
        scores = new int[k];

        for (int i = 0; i < answer.size(); i++) {
            scores[answer.get(i)] += dis[i];
        }
        int tempScore = 0;
        for (int i = 0; i < k; i++) {
            if (scores[i] >= m - 1) tempScore++;
        }
        res = Math.max(res, tempScore);

    }

    static void choose(int currIdx) {
        if (currIdx == n) {

            cal();


            return;

        }

        for (int i = 0; i < k; i++) {
            answer.add(i);
            choose(currIdx + 1);
            answer.remove(answer.size() - 1);
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        dis = new int[n];

        for (int i = 0; i < n; i++) {
            dis[i] = sc.nextInt();
        }


        choose(0);
        System.out.println(res);

    }
}
