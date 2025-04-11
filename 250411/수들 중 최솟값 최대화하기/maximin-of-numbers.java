import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer> answer = new ArrayList<>();
    static boolean[] visited;
    static int[][] arr;
    static int res = Integer.MIN_VALUE;
    
    static void cal() {
        int minn=Integer.MAX_VALUE;

        for (int i = 0; i < answer.size(); i++) {
            minn=Math.min(minn,answer.get(i));
        }
        
    res=Math.max(res,minn);
    }

    static void choose(int currIdx) {
        if (currIdx == n) {

            cal();

            return;
        }


        for (int i = 0; i < n; i++) {
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
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        choose(0);
        System.out.println(res);

    }
}
