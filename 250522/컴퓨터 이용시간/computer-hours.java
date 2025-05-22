import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        int x, v, index, num;

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


        pairs.sort(Comparator.comparing((Pair p) -> p.x));


        boolean[] visited = new boolean[n + 1];
        int[] arr = new int[n + 1];


        for (Pair p : pairs) {
            int x = p.x;
            int v = p.v;
            int index = p.index;

            if (v == 1) {

                for (int i = 1; i <= n; i++) {
                    if (!visited[i]) {
                        visited[i] = true;
                        arr[index] = i;
                        p.num = i;
                        break;
                    }
                }


            } else {
                visited[arr[index]] = false;


            }


        }


        pairs.sort(Comparator.comparing((Pair p) -> p.index));
        for (Pair p : pairs) {
            if (p.v == 1) {
                System.out.print(p.num + " ");

            }
        }


    }
}
