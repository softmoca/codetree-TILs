import java.util.*;

public class Main {

    static class Pair {
        int x, v;

        Pair(int x, int v) {
            this.x = x;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] M = new int[n];
        char[] dir = new char[n];
        for (int i = 0; i < n; i++) {
            M[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
        }
        Pair[] pairs = new Pair[n * 2];

        int curr = 0;
        for (int i = 0; i < n; i++) {
            int next = -1;

            if (dir[i] == 'L') {
                next = curr - M[i];

            } else {
                next = curr + M[i];
            }

            int x1 = -1;
            int x2 = -1;
            if (curr > next) {
                x1 = next;
                x2 = curr;
            } else {
                x1 = curr;
                x2 = next;
            }
            pairs[i * 2] = new Pair(x1, +1);
            pairs[i * 2 + 1] = new Pair(x2, -1);


            curr = next;

        }

        Arrays.sort(pairs,
                Comparator.comparing((Pair p) -> p.x).
                        thenComparing((Pair p) -> -p.v)


        );

     //   System.out.println();

        int sum = 0;
        int start = -1;
        int end = -1;
        int res = 0;
        for (Pair p : pairs) {
            sum = sum + p.v;

            if (sum >= k && start == -1) {
                start = p.x;
            }
            if (sum < k && start != -1) {
                end = p.x;
                res = res + Math.abs(start - end);
                start = -1;
            }


        }
        System.out.println(res);


    }
}