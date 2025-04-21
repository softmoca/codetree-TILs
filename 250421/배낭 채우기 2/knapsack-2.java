import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] w=new int[n];
        int[] v=new int[n];
        int[] dp=new int[m+1];
        
        for (int i = 0; i < n; i++) {
            int ww=sc.nextInt();
            int vv=sc.nextInt();
            w[i]=ww;
            v[i]=vv;
        }


        for (int i = 0; i < m + 1; i++) {
            dp[i]=Integer.MIN_VALUE;
        }
        dp[0] =0;

        for (int i = 1; i < m+1; i++) {
            for (int j = 0; j < n; j++) {
                if(i<w[j]) continue;
                if(dp[ i-w[j]]==Integer.MIN_VALUE ) continue;
                dp[i]=Math.max(dp[i],dp[i-w[j]]+v[j]);
            }
        }
        
        int res=0;
        for (int i = 0; i < m + 1; i++) {
            res=Math.max(res,dp[i]);
        }
        System.out.println(res);
        
        
        
        


    }
}
