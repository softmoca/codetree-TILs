import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer> answer = new ArrayList<>();
    static boolean[] visited;

    static void choose(int currIdx) {
        if (currIdx == n) {
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i) + " ");
            }
            System.out.println();
            return;
        }


        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            answer.add(i);
            visited[i] = true;
            choose(currIdx + 1);
            answer.remove(answer.size() - 1);
            visited[i] = false;


        }


    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];
        choose(0);


    }
}
