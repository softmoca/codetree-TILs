import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.addLast(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.addLast(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.addLast(Integer.parseInt(st.nextToken()));
        }

        while (t-- > 0) {
            q.addFirst(q.removeLast());
        }

        for (int i = 0; i < n; i++) {
            System.out.print(q.removeFirst() + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(q.removeFirst() + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(q.removeFirst() + " ");
        }

    }
}
