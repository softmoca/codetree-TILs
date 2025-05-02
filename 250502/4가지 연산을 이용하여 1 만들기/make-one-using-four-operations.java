import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] answer = new int[3000001];
        boolean[] visited = new boolean[3000001];

        ArrayDeque<Integer> qu = new ArrayDeque<>();
        qu.offer(n);
        visited[n] = true;


        while (!qu.isEmpty()) {
            int x = qu.poll();

            if (x + 1 <= 3000000 && !visited[x + 1]) {
                qu.offer(x + 1);
                visited[x + 1] = true;
                answer[x + 1] = answer[x] + 1;


            }

            if (x - 1 >= 0 && !visited[x - 1]) {
                qu.offer(x - 1);
                visited[x - 1] = true;
                answer[x - 1] = answer[x] + 1;
            }

            if (x % 2 == 0 && !visited[x / 2]) {
                qu.offer(x / 2);
                visited[x / 2] = true;
                answer[x / 2] = answer[x] + 1;
            }
            if (x % 3 == 0 && !visited[x / 3]) {
                qu.offer(x / 3);
                visited[x / 3] = true;
                answer[x / 3] = answer[x] + 1;
            }


        }
        System.out.println(answer[1]);


    }
}
