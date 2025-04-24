import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        long[] dp=new long[1001];
        dp[0]=1;
        dp[1]=2;
        dp[2]=7;
        dp[3]=22;

        for (int i = 4; i <=n ; i++) {
            dp[i]=(dp[i-1]*2+dp[i-2]*3+dp[i-3]*2)%1000000007;

            for (int j = 4; j <=i ; j+=2) {
                dp[i]=(dp[i]+dp[i-j]*2)%1000000007;
            }
        }
        System.out.println(dp[n]);
    }
}
