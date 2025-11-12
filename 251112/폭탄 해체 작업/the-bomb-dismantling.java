import java.io.*;
import java.util.*;

/*

 */


public class Main {

    static class Pair {
        int point, time;

        Pair(int point, int time) {
            this.point = point;
            this.time = time;


        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Pair[] paris = new Pair[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            paris[i] = new Pair(point, time);
        }

        Arrays.sort(paris,
                Comparator.comparing(
                        (Pair p) -> p.time
                ).thenComparing(p -> -p.point)

        );

        int res = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            int currPoint = paris[i].point;
            int currTime = paris[i].time;

            if (time < currTime) {
                res = res + currPoint;
            }
            time++;
        }

        System.out.println(res);


    }
}
