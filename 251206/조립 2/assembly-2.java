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

        boolean[] check = new boolean[n + 1];
        Set<Integer>[] temp = new Set[n + 1];
        for (int i = 0; i < n + 1; i++) {
            temp[i] = new HashSet<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < k; j++) {
                int x=Integer.parseInt(st.nextToken());
                temp[a].add(x);

            }



        }


        int nn = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nn; i++) {
            int x=Integer.parseInt(st.nextToken());
            check[x]=true;
        }


        for (int i = 1; i < n+1; i++) {
            if (check[i]) {
                continue;
            }


            if(temp[i].isEmpty()){
                continue;
            }

            boolean flag=false;
            for (int x : temp[i]) {
                if(!check[x]){
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                check[i] = true;
            }



        }

        int cnt=0;

        for (int i = 1; i < n + 1; i++) {
            if (check[i]) {
                cnt++;
            }

        }
        System.out.println(cnt);


        for (int i = 1; i < n + 1; i++) {
            if (check[i]) {
                System.out.print(i+" ");
            }

        }


    }
}
