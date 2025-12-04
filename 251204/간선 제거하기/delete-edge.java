import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

 */


public class Main {

    static int[][] board;
    static int n;
    static List<Point> points;
    static int[] parent;


    static class Point{
        int row,col;

        Point(int row, int col) {
            this.row=row;
            this.col=col;
        }
    }

    static class Pair{
        int node1,node2,cost;

        Pair(int node1, int node2, int cost) {
            this.node1=node1;
            this.node2=node2;
            this.cost=cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st= new StringTokenizer(br.readLine());
int n=Integer.parseInt(st.nextToken());
int m=Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i]=i;
        }

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            pairs.add(new Pair(a, b, cost));
        }


        pairs.sort(
                Comparator.comparing(
                        (Pair p) -> p.cost
                )
        );

        int res=0;
        for (Pair p : pairs) {
            int rootA = find(p.node1);
            int rootB = find(p.node2);
            if(rootA==rootB) {
                res+=p.cost;
            }
            parent[rootA]=rootB;

        }

        System.out.println(res);




    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    private static int bfs(int start, int end) {
        int[][] dist= new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],-1);
        }

        int startRow = points.get(start).row;
        int startCol = points.get(start).col;
        int endRow = points.get(end).row;
        int endCol = points.get(end).col;

        dist[startRow][startCol]=0;

        Queue<int[]> qu = new ArrayDeque<>();
        qu.offer(new int[]{startRow, startCol});


        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!qu.isEmpty()) {

            int[] curr=qu.poll();
            int currRow=curr[0];
            int currCol=curr[1];

            for (int k = 0; k < 4; k++) {
                int nx = currRow + dx[k];
                int ny = currCol + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if(board[nx][ny]!=-1 && dist[nx][ny]==-1){
                    dist[nx][ny]=dist[currRow][currCol]+1;
                    qu.offer(new int[]{nx, ny});
                }
            }
        }

        return dist[endRow][endCol];







    }
}
