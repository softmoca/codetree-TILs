import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // i = 홍팀 버전, i+n = 백팀 버전
        parent = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a와 b는 다른 팀이어야 함
            // → a의 홍팀 = b의 백팀
            // → a의 백팀 = b의 홍팀
            union(a, b + n);
            union(a + n, b);

            // a의 홍팀 버전과 백팀 버전이 같은 그룹이면 모순!
            if (find(a) == find(a + n) || find(b) == find(b + n)) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}