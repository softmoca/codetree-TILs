import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*

 */


public class Main {
    static int[] parent;
    static int[] parentCnt;

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            parent[y] = x;
            parentCnt[x] += parentCnt[y];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        parentCnt = new int[n + 1];
        Arrays.fill(parentCnt, 1);


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            if (type == 'x') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
                

            } else {
                int a = Integer.parseInt(st.nextToken());
                int parentNode = find(a);
                System.out.println(parentCnt[parentNode]);

            }

        }


    }
}
