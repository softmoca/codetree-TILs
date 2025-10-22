import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] prefixSum=new int[n];
        prefixSum[0]=arr[0];
        for(int i=1; i<n;i++ ){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }

        int res=Integer.MIN_VALUE;

        for(int i=k;i<n;i++){

            res=Math.max(res,prefixSum[i-1]-prefixSum[i-k]+arr[i-k]);
        }
        System.out.print(res);
        
        







        




    }
}