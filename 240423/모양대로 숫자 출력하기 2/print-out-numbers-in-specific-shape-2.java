import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt=0;
        for (int i = 0; i < n; i++) {
        
           
                for (int j = 0; j <n; j++) {
                	cnt+=2;
                    System.out.print(cnt+" ");
                    
                    if (cnt==8) {
                    	cnt=0;
                    }
                }
                
          
            System.out.println();
        }
    }
}