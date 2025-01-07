import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[2*n];
        for(int i=0; i<2*n;i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);
        int minValue=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minValue=Math.min(arr[n+i]-arr[i],minValue);

        }
        System.out.print(minValue);

    }
}