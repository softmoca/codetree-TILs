import java.util.Scanner;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int b = sc.nextInt();
        int[] arr=new int[n+1];
        Arrays.fill(arr,1   );

        for (int i = 0; i < b; i++) {
                int x = sc.nextInt();
                arr[x]=0;
        }
        arr[0]=0;
        int[] sum=new int[n+1];
        sum[0]=0;
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+arr[i];
        }

        int res=Integer.MIN_VALUE;

        for(int i=k;i<=n;i++){
            res=Math.max(res,sum[i]-sum[i-k]);
        }
        System.out.print(k-res);



        // Please write your code here.
    }
}