import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*

 */


public class Main {
    static class Pair {
        int wight, value;

        Pair(int wight, int value) {
            this.wight = wight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(w, v);

        }


        Arrays.sort(pairs,
                Comparator.comparing(
                        (Pair p) -> -(p.value / (double) p.wight)
                )
        );

        System.out.println();
        double res = 0;
        for (Pair p : pairs) {
            int curW = p.wight;
            int curV = p.value;

            if (m >= curW) {
                res = res + curV;
                m = m - curW;
            } else {
                res = res + curV / (double) curW * m;
                break;
            }
        }

        System.out.printf("%.3f", res);
        
        

    }
}
