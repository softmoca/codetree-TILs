import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr= new int[1000001];
        int[] sum= new int[1000001];




        for (int i = 0; i < n; i++) {
            int x= sc.nextInt();
            arr[x]=1;
        }
        for(int i=1;i<=1000000;i++){
            sum[i]=sum[i-1]+arr[i];
        }




        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            if(a==0) a=1;


            int b = sc.nextInt();
            System.out.println(sum[b]-sum[a]);

        }







    }
}