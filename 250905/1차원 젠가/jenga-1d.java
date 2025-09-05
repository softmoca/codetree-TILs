import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start1 = Integer.parseInt(st.nextToken()) - 1;
        int end1 = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        int start2 = Integer.parseInt(st.nextToken()) - 1;
        int end2 = Integer.parseInt(st.nextToken()) - 1;


        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (start1 >= i && end1 >= i) continue;
            list.add(arr[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            if (start2 >= i && end2 >= i) continue;
            list2.add(arr[i]);

        }
        for (int x : list2) {
            System.out.println(x);
        }


    }
}
