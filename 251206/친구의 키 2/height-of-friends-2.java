import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[] inDegree = new int[n + 1];

        List<Integer>[] graph = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            inDegree[b]++;
            graph[a].add(b);
        }



        Queue<Integer> qu = new ArrayDeque<>();


        for (int i = 1; i < n+1; i++) {
            if (inDegree[i] == 0) {
                qu.offer(i);
            }
        }


        List<Integer> res = new ArrayList<>();
        int ans=0;

        while (!qu.isEmpty()) {

            int curr = qu.poll();
            res.add(curr);
            ans++;

            for (int next : graph[curr]) {
                inDegree[next]--;
                if(inDegree[next]==0){
                    qu.offer(next);
                }
            }
        }

        if (ans == n) {
            System.out.println("Consistent");
        }else{
            System.out.println("Inonsistent");
        }



    }
}
