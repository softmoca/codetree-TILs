import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer> answer = new ArrayList<>();
    static boolean[] visited;
    static int[][] arr;
    static int res = Integer.MAX_VALUE;

    static void cal() {
        if(arr[0][answer.get(0)]==0 || arr[answer.get(answer.size()-1)][0]==0) return;
        
        int sum = arr[0][answer.get(0)] + arr[answer.get(answer.size() - 1)][0];
        for (int i = 0; i < answer.size() - 1; i++) {
            
            if(arr[answer.get(i)][answer.get(i+1)]==0) return;
            sum += arr[answer.get(i)][answer.get(i + 1)];
            
        }
        res = Math.min(res, sum);


    }

    static void choose(int currIdx) {
        if (currIdx == n - 1) {

            cal();

            return;
        }


        for (int i = 1; i < n; i++) {
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
