import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//       for (int i = 0; i < anwer.size(); i++) {
////                System.out.print(anwer.get(i) + " ");
////            }
////            System.out.println();
public class Main {

    static class Line {
        int x, y;

        Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int n;
    static Line[] lines;
    static List<Integer> anwer = new ArrayList<>();
    static int[] tempLine = new int[1001];
    static int res = 0;

    static void init() {
        for (int i = 0; i < 1001; i++) {
            tempLine[i] = 0;
        }

    }

    static boolean check() {
        for (int i = 0; i < anwer.size(); i++) {
            int startX = lines[anwer.get(i)].x;
            int startY = lines[anwer.get(i)].y;

            for (int j = startX; j <= startY; j++) {
                tempLine[j]++;
            }
        }

        for (int i = 0; i < 1001; i++) {
            if (tempLine[i] > 1) {
                return false;
            }
        }

        return true;
    }

    static void c(int currIdx, int cnt, int s) {
        if (currIdx == cnt + 1) {

            if (check()) {

                System.out.println(cnt);
                System.exit(0);
                //res = Math.max(res, cnt);

            }
            init();

            return;
        }

        for (int i = s; i < n; i++) {
            anwer.add(i);
            c(currIdx + 1, cnt, i+1);
            anwer.remove(anwer.size() - 1);
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        lines = new Line[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines[i] = new Line(a, b);
        }

        for (int cnt = n; cnt > 0; cnt--) {
            c(1, cnt, 0);

        }


    }
}
