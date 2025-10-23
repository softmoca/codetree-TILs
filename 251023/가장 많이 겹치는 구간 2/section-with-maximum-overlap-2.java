import java.util.*;

public class Main {
    static class Pair{
        int x,v;
        Pair(int x, int v){
            this.x=x;
            this.v=v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Pair[] pairs=new Pair[2*n];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            pairs[i*2]=new Pair(x1,+1);
            pairs[i*2+1]=new Pair(x2,-1);
        }
        Arrays.sort(pairs,
            Comparator.comparing((Pair p)->p.x )
        );

        int res=0;
            int sum=0;
        for(Pair p : pairs){
sum=sum+p.v;
res=Math.max(res,sum);



        }

System.out.print(res);





    }
}