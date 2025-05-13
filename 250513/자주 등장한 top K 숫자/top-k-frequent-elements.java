import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int num, cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Pair[] pairs = new Pair[map.size()];


        int idx = 0;
        for (int x : map.keySet()) {
            pairs[idx++] = new Pair(x, map.get(x));

        }

        Arrays.sort(pairs,
                Comparator.comparing((Pair p) -> p.cnt, Comparator.reverseOrder()).
                        thenComparing((Pair p) -> p.num,Comparator.reverseOrder())
        );

        for (int i = 0; i < k; i++) {
            System.out.print(pairs[i].num + " ");

        }


    }
}
