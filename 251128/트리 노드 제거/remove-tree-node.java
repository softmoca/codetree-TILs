import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static List<Integer>[] graph;

    static boolean[] check;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        check = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int rootIdx = 0;
        for (int i = 0; i < n; i++) {
            int b = arr[i];
            if (b == -1) {
                rootIdx = i;
                continue;
            }

            graph[i].add(b);
            graph[b].add(i);
        }

        graph[target] = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int node : graph[i]) {
                if (node != target) {
                    temp.add(node);
                }

            }
            graph[i] = temp;
        }


        if (graph[rootIdx].size() <= 0) {
            System.out.println(0);

        } else {
            check[rootIdx] = true;

            dfs(rootIdx);
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (check[i] && graph[i].size() == 1) {
                    cnt++;
                }


            }
            
            if(cnt==1){
                System.out.println(1);
            }else{
                System.out.println(cnt-1);
            }
            
            //System.out.println(cnt);


        }


    }

    static void dfs(int start) {

        for (int node : graph[start]) {
            if (!check[node]) {
                check[node] = true;
                dfs(node);

            }


        }


    }


}
