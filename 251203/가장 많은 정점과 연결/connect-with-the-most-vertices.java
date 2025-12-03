import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;

            size[rootB] = Math.min(size[rootA], size[rootB]);
            size[rootA] = 100001;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 초기화
        parent = new int[n + 1];
        size = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }


        // 간선 입력 및 Union
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }


        Queue<Integer> pq = new PriorityQueue<>();


        for (int i = 1; i <= n; i++) {
            if (find(i) == i) {  // 루트인 경우만
                pq.add(size[i]);
            }
        }


        int res = 0;

        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            res = res + a + b;
            pq.offer(a);


        }
        if (res <= k) {
            System.out.println(res);
        } else {
            System.out.println("NO");
        }


    }
}
