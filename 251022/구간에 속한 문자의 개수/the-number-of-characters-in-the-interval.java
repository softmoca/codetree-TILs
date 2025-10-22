import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] arrA=new int[n+1][m+1];
        int[][] arrB=new int[n+1][m+1];
        int[][] arrC=new int[n+1][m+1];
        int[][] sumA=new int[n+1][m+1];
        int[][] sumB=new int[n+1][m+1];
        int[][] sumC=new int[n+1][m+1];

        for(int i=1; i<=n;i++){
            String input= sc.next();
            for(int j=0; j<m;j++ ){
                char x=input.charAt(j);
                if(x=='a'){
                    arrA[i][j+1]=1;
                }else if(x=='b'){
                    arrB[i][j+1]=1;
                }else{
                    arrC[i][j+1]=1;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                sumA[i][j]=sumA[i-1][j]+sumA[i][j-1]-sumA[i-1][j-1]+arrA[i][j];
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                sumB[i][j]=sumB[i-1][j]+sumB[i][j-1]-sumB[i-1][j-1]+arrB[i][j];
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                sumC[i][j]=sumC[i-1][j]+sumC[i][j-1]-sumC[i-1][j-1]+arrC[i][j];
            }
        }
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<k;i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int a=sumA[x2][y2]-sumA[x1-1][y2]-sumA[x2][y1-1]+sumA[x1-1][y1-1];
            int b=sumB[x2][y2]-sumB[x1-1][y2]-sumB[x2][y1-1]+sumB[x1-1][y1-1];
            int c=sumC[x2][y2]-sumC[x1-1][y2]-sumC[x2][y1-1]+sumC[x1-1][y1-1];
            sb.append(a+" "+b+" "+c);
            sb.append(  "\n");

        }
System.out.print(sb);






  
    }
}