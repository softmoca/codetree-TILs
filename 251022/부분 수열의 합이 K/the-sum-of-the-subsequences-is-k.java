import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        sum[0]=0;
        for(int i=1; i<=n;i++){
            sum[i]=sum[i-1]+arr[i];
        }
        int cnt=0;

        for(int size=1; size<=n;size++){
            cnt=cnt+find(size,sum,n,k);
        }
        System.out.print(cnt);


    }
    static int find(int size,int[] sum,int n,int k){
        int tempCnt=0;
        for(int i=size;i<=n;i++){
            if(sum[i]-sum[i-size]==k){
tempCnt++;
            }
        }

return tempCnt;

    }



}