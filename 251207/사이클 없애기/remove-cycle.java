import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());   // 노드 수
        int m1 = Integer.parseInt(st.nextToken());  // 단방향 간선 수
        int m2 = Integer.parseInt(st.nextToken());  // 양방향 간선 수 (사용 안 함)
        
        // 그래프 구성 (단방향 간선만)
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1];  // 진입 차수
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 단방향 간선 입력
        for (int i = 0; i < m1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);  // a → b
            inDegree[b]++;
        }
        
        // 양방향 간선은 읽기만 하고 무시
        for (int i = 0; i < m2; i++) {
            br.readLine();
        }
        
        // 위상 정렬로 사이클 검사 (Kahn's Algorithm)
        Queue<Integer> queue = new LinkedList<>();
        
        // 진입 차수가 0인 노드를 큐에 추가
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;  // 처리된 노드 수
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            
            // 현재 노드에서 나가는 간선 제거
            for (int next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        // 모든 노드를 처리했으면 사이클 없음
        if (count == n) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}