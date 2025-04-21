import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (arr[i] > j) continue;
                if (dp[j - arr[i]] == false) continue;
                dp[j] = true;
            }
        }

        for (int i = 0; i < sum + 1; i++) {
            if (dp[i])
                if(  i*2==sum   ){
                    System.out.println("Yes");
                    System.exit(0);
                }
                
          
    
            }

        }

        System.out.println("No");


    }
}
