import java.io.*;
import java.util.*;

public class Main {

    static class Line {
        int start, end;

        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            lines[i] = new Line(s, e);
        }
        Arrays.sort(lines,
                Comparator.comparing(
                        (Line x) -> x.start

                )
        );

      

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
       dp[i]=1;
        }

        for (int i = 1; i < n; i++) {

            for (int j = 0; j <i ; j++) {
                
                if(  lines[j].end<lines[i].start ){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                
                
            }
            
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
        

    }
}
