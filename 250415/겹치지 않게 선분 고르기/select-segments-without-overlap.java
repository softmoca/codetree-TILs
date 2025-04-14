import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int n;
    static List<Integer> answer = new ArrayList<>();
    static int res = 0;
    static boolean[] visited = new boolean[1001];

    static boolean isOk() {

        for (int i = 0; i < answer.size(); i++) {
            Pair pair = paris[answer.get(i)];
            int start = pair.start;
            int end = pair.end;

            for (int j = start; j <= end; j++) {
                if (visited[j]) return false;
                visited[j] = true;
            }
        }
        return true;
    }

    static void choose(int currIdx, int cnt, int startIdx) {
        if (currIdx == cnt) {
            if (isOk()) {
                res = Math.max(res, answer.size());
            }

            visited = new boolean[1001];
            return;
        }

        for (int i = startIdx; i < n; i++) {
            answer.add(i);
            choose(currIdx + 1, cnt, i + 1);
            answer.remove(answer.size() - 1);
        }


    }

    static Pair[] paris;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        paris = new Pair[n];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            paris[i] = new Pair(start, end);
        }

        for (int i = 1; i < n + 1; i++) {
            choose(0, i, 0);
        }

        System.out.println(res);


    }
}
