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
            size[rootB] += size[rootA];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 초기화
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // 간선 입력 및 Union
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int rootA = find(A);
        int rootB = find(B);

        // A, B 제외한 연결 요소들의 크기 수집
        List<Integer> others = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (find(i) == i) {  // 루트인 경우만
                if (i != rootA && i != rootB) {
                    others.add(size[i]);
                }
            }
        }

        // 크기 내림차순 정렬
        others.sort((a, b) -> b - a);

        // A의 크기 + 상위 K개 연결 요소
        long answer = size[rootA];
        for (int i = 0; i < Math.min(K, others.size()); i++) {
            answer += others.get(i);
        }

        System.out.println(answer);
    }
}