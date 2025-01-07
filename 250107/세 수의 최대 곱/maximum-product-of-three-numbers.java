import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];
        for(int i=0; i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);


        int temp1=arr[0]*arr[1]*arr[n-1];
        int temp2=arr[n-3]*arr[n-2]*arr[n-1];

        System.out.print(Math.max(temp1,temp2));


    }
}