import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt=1;
        
        for (int i = 1; i <= n; i++) {
        	for (int j=1; j<i+1;j++) {
        		System.out.print(i +" ");
        		
        		
        	}
                
          
            System.out.println();
        }
    }
}