import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[11];
        for (int i = 0; i < 11; i++) {
            arr[i] = -1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (arr[a] == -1) {
                arr[a] = b;
            } else {
                if(arr[a]!=b){
                    count++;
                }
                
                arr[a] = b;

            }

        }
        System.out.println(count);


    }


}
