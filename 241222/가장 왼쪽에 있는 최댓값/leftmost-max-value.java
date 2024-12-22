import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        int firstMax=0;
        int firstMaxIdx=0;
        for(int i=0;i<n;i++){
            if(a[i]>firstMax){
                firstMax=a[i];
            }
        }

// System.out.print("t"+firstMax);
  for(int i=0;i<n;i++){
            if(a[i]==firstMax){
            
                firstMaxIdx=i;
                    System.out.print(firstMaxIdx+1+" ");
                break;
            }
        }



    
        while(firstMaxIdx!=0){
            firstMax=0;
            for(int i=0;i<firstMaxIdx;i++){
                if(a[i]>firstMax){
                firstMax=a[i];
             
            }
            }
//System.out.printf("%d max\n\n",firstMax);
            for(int i=0;i<firstMaxIdx;i++){
                if(a[i]==firstMax){
                   System.out.print(i+1+" ");
                    firstMaxIdx=i;
                break;
                }
            }

            if(firstMaxIdx==0){
                break;
            }




        }


    }
}