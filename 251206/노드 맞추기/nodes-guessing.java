import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        // 노드 이름 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] names = new String[n];
        Map<String, Integer> nameToIdx = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            names[i] = st.nextToken();
            nameToIdx.put(names[i], i);
        }

        int m = Integer.parseInt(br.readLine());

        // 각 노드의 조상 집합
        Set<Integer>[] ancestors = new Set[n];
        for (int i = 0; i < n; i++) {
            ancestors[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();  // 자손
            String y = st.nextToken();  // 조상
            int xIdx = nameToIdx.get(x);
            int yIdx = nameToIdx.get(y);
            ancestors[xIdx].add(yIdx);  // x의 조상에 y 추가
        }

        // 각 노드의 직접 부모 찾기
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int x = 0; x < n; x++) {
            // x의 조상들 중 직접 부모 찾기
            for (int y : ancestors[x]) {
                boolean isDirect = true;
                
                // y가 다른 조상의 조상인지 확인
                for (int z : ancestors[x]) {
                    if (y != z && ancestors[z].contains(y)) {
                        // z의 조상에 y가 있음 → y는 직접 부모가 아님
                        isDirect = false;
                        break;
                    }
                }
                
                if (isDirect) {
                    parent[x] = y;
                    break;
                }
            }
        }

        // 자식 리스트 구성
        List<String>[] children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        List<String> roots = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                roots.add(names[i]);  // 부모 없음 = 루트
            } else {
                children[parent[i]].add(names[i]);
            }
        }

        // 정렬
        Collections.sort(roots);
        for (int i = 0; i < n; i++) {
            Collections.sort(children[i]);
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        
        // 트리 수
        sb.append(roots.size()).append("\n");
        
        // 루트 노드들
        sb.append(String.join(" ", roots)).append("\n");
        
        // 각 노드 정보 (사전순)
        String[] sortedNames = names.clone();
        Arrays.sort(sortedNames);
        
        for (String name : sortedNames) {
            int idx = nameToIdx.get(name);
            sb.append(name).append(" ").append(children[idx].size());
            for (String child : children[idx]) {
                sb.append(" ").append(child);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
