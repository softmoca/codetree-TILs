import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int[] l=new int[n];
        int[] r=new int[n];
        
        if(str.charAt(0)=='C'){
            l[0]=1;
        }
        if(str.charAt(n-1)=='W'){
            r[n-1]=1;
        }

        for(int i=1;i<n;i++){
            if(str.charAt(i)=='C'){
                l[i]=l[i-1]+1;
            }else{
                l[i]=l[i-1];
            }
        }

        for(int i=n-2;i>=0;i--){
            if(str.charAt(i)=='W'){
                r[i]=r[i+1]+1;
            }else{
                r[i]=r[i+1];
            }
        }


        int res=0;

        for(int i=1;i<n-1;i++){
            if(str.charAt(i)=='O'){
                res=res+l[i-1]*r[i+1 ];
            }

        }
System.out.print(res);







    }
}