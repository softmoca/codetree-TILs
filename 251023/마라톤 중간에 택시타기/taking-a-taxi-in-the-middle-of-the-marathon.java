import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[] paris = new Pair[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            paris[i] = new Pair(a, b);
        }

        int[] l = new int[n];
        int[] r = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int x1 = paris[i].x;
            int y1 = paris[i].y;
            int x2 = paris[i + 1].x;
            int y2 = paris[i + 1].y;
            int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
            l[i + 1] = l[i] + dist;
        }


        for (int i = n - 1; i > 0; i--) {
            int x1 = paris[i].x;
            int y1 = paris[i].y;
            int x2 = paris[i - 1].x;
            int y2 = paris[i - 1].y;
            int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
            r[i - 1] = r[i] + dist;

        }
        int res=Integer.MAX_VALUE;
        for (int i = 1; i < n-1; i++) {
            int x1 = paris[i+1].x;
            int y1 = paris[i+1].y;
            int x2 = paris[i - 1].x;
            int y2 = paris[i - 1].y;
            int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
            res=Math.min(res,l[i-1]+r[i+1]+dist);
            
            
        }
        

        System.out.println(res);


    }
}
