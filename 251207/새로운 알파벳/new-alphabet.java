import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        Set<Character> usedChars = new HashSet<>();  // 사용된 알파벳

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            for (char c : words[i].toCharArray()) {
                usedChars.add(c);
            }
        }

        // 그래프 생성 (알파벳 간의 순서 관계)
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (char c : usedChars) {
            graph.put(c, new HashSet<>());
            inDegree.put(c, 0);
        }

        // 연속된 단어 쌍에서 순서 관계 추출
        boolean impossible = false;

        for (int i = 0; i < n - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int minLen = Math.min(word1.length(), word2.length());
            boolean foundDiff = false;

            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    // c1이 c2보다 앞 → c1 → c2 간선
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    foundDiff = true;
                    break;
                }
            }

            // 앞 단어가 더 긴데 뒤 단어가 접두사인 경우 → 불가능
            // 예: "abc" 다음에 "ab"
            if (!foundDiff && word1.length() > word2.length()) {
                impossible = true;
            }
        }

        if (impossible) {
            System.out.println(-1);
            return;
        }

        // 위상 정렬
        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        boolean multipleAnswers = false;

        // 진입 차수가 0인 노드 추가
        for (char c : usedChars) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            // 진입 차수 0인 노드가 2개 이상이면 순서가 여러 개 가능
            if (queue.size() > 1) {
                multipleAnswers = true;
            }

            char cur = queue.poll();
            result.append(cur);

            for (char next : graph.get(cur)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        // 결과 출력
        if (result.length() != usedChars.size()) {
            // 모든 노드를 방문 못함 → 사이클 존재 → 불가능
            System.out.println(-1);
        } else if (multipleAnswers) {
            // 여러 답이 가능
            System.out.println("inf");
        } else {
            System.out.println(result);
        }
    }
}