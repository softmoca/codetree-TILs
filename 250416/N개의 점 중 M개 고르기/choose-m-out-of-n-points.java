import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static Pair[] pairs;
    static List<Integer> answer = new ArrayList<>();
    static int res = Integer.MAX_VALUE;

    static void cal() {
        int resMax = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                Pair pair1 = pairs[answer.get(i)];
                Pair pair2 = pairs[answer.get(j)];

                int temp = (pair1.x - pair2.x) * (pair1.x - pair2.x) + (pair1.y - pair2.y) * (pair1.y - pair2.y);
                resMax = Math.max(temp, resMax);
            }
        }
        res = Math.min(res, resMax);
    }

    static void choose(int currIdx, int startIdx) {
        if (currIdx == m) {
            cal();


            return;
        }
        for (int i = startIdx; i < n; i++) {
            answer.add(i);
            choose(currIdx + 1, i + 1);
            answer.remove(answer.size() - 1);
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();


        pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pairs[i] = new Pair(x, y);
        }


        choose(0, 0);
        System.out.println(res);
    }
}
