import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] arrA=new int[n+1][n+1];
        int[][] arrB=new int[n+1][n+1];
        int[][] arrC=new int[n+1][n+1];
        int[][] sumA=new int[n+1][n+1];
        int[][] sumB=new int[n+1][n+1];
        int[][] sumC=new int[n+1][n+1];

        for(int i=1; i<=n;i++){
            String input= sc.next();
            for(int j=0; j<=m;j++ ){
                char x=input.charAt(j);
                if(x=='a'){
                    arrA[i][j]=1;
                }else if(x=='b'){
                    arrB[i][j]=1;
                }else{
                    arrC[i][j]=1;
                }
            }
        }

        





  
    }
}