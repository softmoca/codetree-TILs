import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[] points;
    static int[] scores;
    static List<Integer> answer = new ArrayList<>();
    static int res = 0;

    static void choose(int currIdx) {
        if (currIdx == n) {


            for (int i = 0; i < scores.length; i++) {
                scores[i] = 0;
            }

            for (int i = 0; i < answer.size(); i++) {
                scores[answer.get(i) - 1] += points[i];
            }
//            for (int x : scores) {
//                System.out.print(x + " ");
//            }
//            System.out.println();

            int sum = 0;

            for (int i = 0; i < scores.length; i++) {
                if (scores[i] >= m - 1) sum++;
            }

            res = Math.max(res, sum);

            return;
        }

        for (int i = 1; i <= k; i++) {
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
        points = new int[n];
        scores = new int[k];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        choose(0);
        System.out.println(res);

    }
}
