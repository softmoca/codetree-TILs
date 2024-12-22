import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);

        int n= sc.nextInt();
        int sum=0;
        for(int i=1;i<n/2;i++){
            if(n%i!=0){
                continue;
            }
            sum=sum+i+n/i;
        }


        if( (sum-n)==n   ){
              System.out.print('P');
        }else{
              System.out.print('N');
        }

      

    }
}