import java.util.*;

public class Main {
    static class Pair{
        int idx,x,v;
        Pair(int idx, int x, int v){
            this.idx=idx;
            this.x=x;
            this.v=v;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Pair[] pairs= new Pair[n*2];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            pairs[i*2]=new Pair(i+1,x1,1);
            pairs[i*2+1]=new Pair(i+1,x2,-1);
        }

        Set<Integer> set= new HashSet<>();

        int[] res=new int[n+1];


        Arrays.sort(pairs,
            Comparator.comparing(
                (Pair p)-> p.x
            )
        );
        Queue<Integer> pq= new PriorityQueue<>();
        for(int i=1;i<=n;i++){
        pq.add(i);
        }


        for(Pair p: pairs){
            if(p.v>0){
                res[p.idx]=pq.poll();
            }else{
pq.offer(res[p.idx]);
            }

        }

        for(int i=1;i<=n;i++){
            System.out.print(res[i]+" ");
        }






    }
}