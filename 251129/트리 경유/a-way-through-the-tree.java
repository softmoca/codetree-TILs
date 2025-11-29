import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1200000;

    // 변수 선언
    public static int n, q;
    public static boolean[] colored = new boolean[MAX_N + 1];

    public static int lastColoredNode(int dest) {
        // 가는 길에 색칠된 노드가 없다면 0을 반환합니다.
        int ret = 0;

        while (dest > 0) {
            // 해당 위치의 노드가 색칠되었다면 반환할 값을 갱신합니다.
            if (colored[dest]) {
                ret = dest;
                //break;
            }

            // dest에서 2를 나눠줄 때마다 자신의 부모 노드로 가게 됩니다.
            dest /= 2;
        }

        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        q = sc.nextInt();

        // q개의 줄에 걸쳐 노드를 입력받습니다.
        while (q-- > 0) {
            int dest = sc.nextInt();

            // 입력받은 노드를 따라 갈 때, 색칠된 노드가 있는지 확인합니다.
            int ans = lastColoredNode(dest);
            System.out.println(ans);

            // 만약 색칠된 노드가 없었다면 dest 노드에 색칠해줍니다.
            if (ans == 0)
                colored[dest] = true;
        }
    }
}
