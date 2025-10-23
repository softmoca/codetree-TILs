import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt=new int[200001];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            cnt[x1]++;
            cnt[x2]--;
        }

        int sum=0;
        int res=0;

        for(int i=0;i<200000;i++){
            sum=sum+cnt[i];

res=Math.max(res,sum);

        }
System.out.print(res);



    }
}