import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair b) {
        if (x != b.x) {
            return x - b.x;
        }
        return y - b.y;
    }
}

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 11;

    public static int n, m;
    static int[] targetMapping = new int[MAX_N]; // num1 대체

    public static void setupTargetMapping() {
        for (int i = 0; i < n; i++) {
            targetMapping[i] = i;
        }

        for (Pair line : lines) {
            int idx = line.y;
            int tmp = targetMapping[idx];
            targetMapping[idx] = targetMapping[idx + 1];
            targetMapping[idx + 1] = tmp;
        }
    }

    public static ArrayList<Pair> lines = new ArrayList<>();
    public static ArrayList<Pair> selectedLines = new ArrayList<>();

    public static int ans = INT_MAX;

    // 처음 상황과, 선택한 가로줄만 사용했을 때의
    // 상황을 시뮬레이션하여
    // 둘의 결과가 같은지 확인합니다.
    public static boolean possible() {
        int[] currentMapping = new int[MAX_N];

        for (int i = 0; i < n; i++) {
            currentMapping[i] = i;
        }

        for (Pair line : selectedLines) {
            int idx = line.y;
            int tmp = currentMapping[idx];
            currentMapping[idx] = currentMapping[idx + 1];
            currentMapping[idx + 1] = tmp;
        }

        for (int i = 0; i < n; i++) {
            if (targetMapping[i] != currentMapping[i]) {
                return false;
            }
        }

        return true;
    }

    public static void findMinLines(int cnt) {
        if (cnt == m) {
            if (possible()) {
                ans = Math.min(ans, (int) selectedLines.size());
            }
            return;
        }

        selectedLines.add(lines.get(cnt));
        findMinLines(cnt + 1);
        selectedLines.remove(selectedLines.size() - 1);

        findMinLines(cnt + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines.add(new Pair(b, a - 1));
        }

        Collections.sort(lines);
        setupTargetMapping();
        findMinLines(0);

        System.out.print(ans);
    }
}
