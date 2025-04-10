import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int res = Integer.MIN_VALUE;
    static int n;
    static int m;
    static Point[] points;
    static List<Integer> answerM = new ArrayList<>();
    static int farX1;
    static int farY1;
    static int farX2;
    static int farY2;
    static List<Integer> answerM2 = new ArrayList<>();
    static int answeR = Integer.MAX_VALUE;

    static void chooseM(int currIdx, int start) {

        if (currIdx == m) {
            res = 0;
            chooseM2(0, 0);


            answeR = Math.min(answeR, res);


            return;
        }


        for (int i = start; i < n; i++) {
            answerM.add(i);
            chooseM(currIdx + 1, i + 1);
            answerM.remove(answerM.size() - 1);
        }


    }

    static void chooseM2(int currIdx, int start) {
        if (currIdx == 2) {


            int dis = 0;
            dis += (int) Math.pow((points[answerM.get(answerM2.get(0))].x - points[answerM.get(answerM2.get(1))].x), 2);
            dis += (int) Math.pow((points[answerM.get(answerM2.get(0))].y - points[answerM.get(answerM2.get(1))].y), 2);


            res = Math.max(res, dis);

            return;
        }

        for (int i = start; i < m; i++) {
            answerM2.add(i);
            chooseM2(currIdx + 1, i + 1);
            answerM2.remove(answerM2.size() - 1);

        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        points = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }


        chooseM(0, 0);


        System.out.println(answeR);

    }
}

