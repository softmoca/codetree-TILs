import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        int x, v, index;

        public Pair(int x, int v, int index) {
            this.x = x;
            this.v = v;
            this.index = index;
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pairs.add(new Pair(x, 1, i));
            pairs.add(new Pair(y, -1, i));
        }

        Set<Integer> visited = new HashSet<>();
        pairs.sort(
                Comparator.comparing(
                        (Pair p) -> p.x
                )

        );

        int res = 0;


        for (Pair p : pairs) {
            int v = p.v;
            int idx = p.index;

            if (v == 1) {
                if (visited.size() == 0) {
                    res++;      visited.add(idx);
                }
          
            } else {
                visited.remove(idx);
            }
        }
        System.out.println(res);


    }
}
