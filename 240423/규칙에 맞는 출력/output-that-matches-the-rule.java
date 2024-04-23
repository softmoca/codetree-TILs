import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        for (int i = N; i >= 1; i--) {
            for (int j = i; j <= N; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}