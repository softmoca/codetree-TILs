import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int x, v;

        public Pair(int x, int v) {
            this.x = x;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            pairs.add(new Pair(x1, +1));
            pairs.add(new Pair(x2, -1));
        }

        pairs.sort(
                Comparator.comparing((Pair p) -> p.x)
        );


        int res = 0;
        int sum = 0;
        int startX = 0;
        int endX = 0;
        for (Pair p : pairs) {
            int x = p.x;
            int v = p.v;

            if (v == 1) {
                if (sum == 0) {
                    startX = x;
                }

                sum++;

            } else {
                sum--;
                if (sum == 0) {
                    endX = x;
                    res += endX - startX;
                }
            }

        }

        System.out.println(res);


    }
}
