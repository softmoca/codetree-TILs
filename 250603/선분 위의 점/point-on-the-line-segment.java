import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int start;
        int end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int n;
    static int m;
    static int[] points;
    static Point[] lines;

    static int find(int left, int right, int target) {

        while (left <= right) {

            int mid = (left + right) / 2;
            if (mid == target) {
                return 1;
            } else if (mid < target) {
                left = mid + 1;
            } else if (mid > target) {
                right = mid - 1;
            }


        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        points = new int[n];
        lines = new Point[m];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            lines[i] = new Point(x, y);
        }

        for (Point p : lines) {
            int cnt = 0;
            int left = p.start;
            int right = p.end;

            for (int i = 0; i < n; i++) {
                cnt += find(left, right, points[i]);
            }


            System.out.println(cnt);
        }


    }
}
