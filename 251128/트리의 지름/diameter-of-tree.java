import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*

 */


public class Main {
    static int n;
    static int[] dist;

    static List<int[]>[] grpah;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        grpah = new List[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            grpah[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            grpah[a].add(new int[]{b, cost});
            grpah[b].add(new int[]{a, cost});
        }
        Arrays.fill(dist, -1);

        dist[1] = 0;

        dfs(1);

        int maxNode = -1;
        int maxValue = -1;
        for (int i = 1; i <= n; i++) {
            if (maxValue < dist[i]) {
                maxValue = dist[i];
                maxNode = i;
            }
        }
        //System.out.println(maxNode + " " + maxValue);

        Arrays.fill(dist, -1);

        dist[maxNode] = 0;
        dfs(maxNode);


        maxNode = -1;
        maxValue = -1;
        for (int i = 1; i <= n; i++) {
            if (maxValue < dist[i]) {
                maxValue = dist[i];
                maxNode = i;
            }
        }
        System.out.println(maxValue);

    }

    static void dfs(int start) {

        for (int[] now : grpah[start]) {
            int nextNode = now[0];
            int cost = now[1];

            if (dist[nextNode] == -1) {
                dist[nextNode] = dist[start] + cost;
                dfs(nextNode);
            }
        }
    }


}
