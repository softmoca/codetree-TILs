import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
      
        
       
        for(int i = 0; i < n; i++) {
        	for(int k=0; k<2*i;k++) {
        		System.out.print(" ");
        	}
            for(int j = 2*i; j<2*n-1; j++)
                System.out.print("* ");
  
            System.out.println();
        }
  
        
        
        
    }

}