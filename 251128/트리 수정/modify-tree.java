import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*

 */


public class Main {
    static int n;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int res = -1;
        for (int i = 0; i < n - 1; i++) {

            graph = new List[n];
            for (int j = 0; j < n; j++) {
                graph[j] = new ArrayList<>();
            }


            int cost = arr[i][2];

            for (int j = 0; j < n - 1; j++) {
                if (j == i) continue;
                int a = arr[j][0];
                int b = arr[j][1];
                int c = arr[j][2];


                graph[a].add(new int[]{b, c});
                graph[b].add(new int[]{a, c});


            }
            dist = new int[n];
            Arrays.fill(dist, -1);
            dist[0] = 0;

            dfs(0);

            int maxNode = -1;
            int maxValue = -1;
            for (int k = 0; k < n; k++) {
                if (maxValue < dist[k]) {
                    maxValue = dist[k];
                    maxNode = k;
                }
            }

            Arrays.fill(dist, -1);

            dist[maxNode] = 0;
            dfs(maxNode);


            maxNode = -1;
            maxValue = -1;
            for (int k = 0; k < n; k++) {
                if (maxValue < dist[k]) {
                    maxValue = dist[k];
                    maxNode = k;
                }
            }

            int maxxx1 = maxValue;

            int temp = -1;
            for (int j = 0; j < n; j++) {
                if (dist[j] == -1) {
                    temp = j;
                    break;
                }
            }

            //
            Arrays.fill(dist, -1);
            dist[temp] = 0;
            dfs(temp);

            maxNode = -1;
            maxValue = -1;
            for (int k = 0; k < n; k++) {
                if (maxValue < dist[k]) {
                    maxValue = dist[k];
                    maxNode = k;
                }
            }

            Arrays.fill(dist, -1);

            dist[maxNode] = 0;
            dfs(maxNode);


            maxNode = -1;
            maxValue = -1;
            for (int k = 0; k < n; k++) {
                if (maxValue < dist[k]) {
                    maxValue = dist[k];
                    maxNode = k;
                }
            }

            int maxxx2 = maxValue;
            res = Math.max(res, maxxx1 + maxxx2 + cost);

        }
        System.out.println(res);


    }

    static int[] dist;


    static void dfs(int start) {

        for (int[] now : graph[start]) {
            int nextNode = now[0];
            int cost = now[1];

            if (dist[nextNode] == -1) {
                dist[nextNode] = dist[start] + cost;
                dfs(nextNode);
            }
        }
    }


}
