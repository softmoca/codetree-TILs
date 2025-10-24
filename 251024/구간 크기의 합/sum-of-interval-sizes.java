import java.util.*;


public class Main {
    static class Pair{
        int x,v;
        Pair(int x,int v){
            this.x=x;
            this.v=v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        Pair[] pairs= new Pair[2*n];


        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pairs[i*2]=new Pair(a,+1);
            pairs[i*2+1]=new Pair(b,-1);

        }

        Arrays.sort(pairs,
        Comparator.comparing(
            (Pair p) -> p.x)

        );

        int start=-1;
        int sum=0;
        int res=0;

        for(Pair p:pairs){
            sum=sum+p.v;

            if(sum>0 && start==-1){
                start=p.x;

            }

            if(sum<=0){
                res=res+Math.abs(start-p.x);
                start=-1;
            }
        }
        System.out.print(res);



        




    }
}