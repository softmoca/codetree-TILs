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
            int x = sc.nextInt();
            int y = sc.nextInt();
            pairs.add(new Pair(x, 1));
            pairs.add(new Pair(y, -1));

        }

        pairs.sort(
                Comparator.comparing(
                        (Pair p) -> p.x
                )


        );


        int res = 0;
        int sum = 0;
        for (Pair p : pairs) {

            int v = p.v;

            sum += v;
            res = Math.max(res, sum);


        }
        System.out.println(res);


    }
}
