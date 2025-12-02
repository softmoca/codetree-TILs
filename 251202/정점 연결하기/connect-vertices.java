import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*

 */


public class Main {
    static int[] parent;

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
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());


        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);

        }

        int res1 = 1;
        for (int i = 2; i <= n; i++) {
            if (find(res1) != find(i)) {
                System.out.println(res1 + " " + i);
                break;
            }

        }


    }
}
