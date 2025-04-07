import java.io.IOException;
import java.util.Scanner;

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
    static int[] tempLine = new int[1001];
    static int res = 0;

    static boolean[] cc;
    static boolean[] vi;

    static boolean dfsCheck() {
        for (int i = 0; i < n; i++) {
            if (cc[i]) {
                int startX = lines[i].x;
                int startY = lines[i].y;
                for (int j = startX; j <= startY; j++) {
                    tempLine[j]++;
                }
            }
        }

        for (int i = 0; i < 1001; i++) {
            if (tempLine[i] > 1) {
                return false;
            }
        }

        return true;
    }

    static void dfs(int idx) {
        if (idx == n) {
            for (int i = 0; i < 1001; i++) {
                tempLine[i] = 0;
            }
            if (dfsCheck()) {
                int cnt = 0;

                for (int i = 0; i < n; i++) {
                    if (cc[i]) {
                        cnt++;
                    }
                }
                res = Math.max(res, cnt);


            }
            return;
        }

        if (!vi[idx]) {
            vi[idx] = true;
            cc[idx] = true;
            dfs(idx + 1);
            vi[idx] = false;


        }

        if (!vi[idx]) {
            cc[idx] = false;
            dfs(idx + 1);
            vi[idx] = false;
        }


    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        lines = new Line[n];
        vi = new boolean[n];
        cc = new boolean[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines[i] = new Line(a, b);
        }

        dfs(0);

        System.out.println(res);

    }
}
