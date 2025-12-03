import java.io.*;
import java.util.*;

/*

 */


public class Main {

    static int[] parent;
    static int[] size;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[100001];
        size = new int[100001];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
            System.out.println(size[find(a)]);


        }


    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];

        }


    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }


        return parent[x] = find(parent[x]);
    }
}
