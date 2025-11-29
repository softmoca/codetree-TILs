import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 이진 검색 트리의 노드 정의
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // 루트 노드
    static Node root;
    static StringBuilder sb = new StringBuilder();

    // BST 삽입 함수
    static Node insert(Node node, int value) {
        // 현재 위치가 비어있으면 새 노드를 만든다.
        if (node == null) {
            return new Node(value);
        }

        // 값이 더 작으면 왼쪽으로
        if (value < node.value) {
            node.left = insert(node.left, value);
        }
        // 값이 더 크면 오른쪽으로
        else {
            node.right = insert(node.right, value);
        }

        return node; // 변경된(또는 그대로인) 서브트리의 루트를 반환
    }

    // 후위 순회: 왼쪽 → 오른쪽 → 현재
    static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 전위 순회 결과를 한 줄씩 읽으면서 그대로 BST에 삽입
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            root = insert(root, value);
        }

        // 완성된 BST를 후위 순회하며 출력
        postOrder(root);
        System.out.print(sb.toString());
    }
}
