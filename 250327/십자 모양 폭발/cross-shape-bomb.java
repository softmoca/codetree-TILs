import java.util.Scanner;

public class Main {
    static int n;
    static int row;
    static int col;
    static int[][] arr;
    static int[][] temp;

    static void boom() {
        int size = arr[row][col];
        arr[row][col] = 0;
        int x = row;
        int y = col;
        for (int i = 1; i < size; i++) {
            if (x - 1 >= 0) {
                arr[--x][col] = 0;
            }
        }

        for (int i = 1; i < size; i++) {
            if (y + 1 < n) {
                arr[row][++y] = 0;
            }
        }
        x = row;
        y = col;
        for (int i = 1; i < size; i++) {
            if (x + 1 < n) {
                arr[++x][col] = 0;
            }
        }

        for (int i = 1; i < size; i++) {
            if (y - 1 >= 0) {
                arr[row][--y] = 0;
            }
        }

    }

    static void gravity() {
        for(int i=0; i<n;i++){
            gravityCell(i);
        }
    }
    static void gravityCell(int col){
        int[] temp=new int[n];
        int idx=0;
        for(int i=0; i<n;i++){
            if(arr[n-1-i][col]==0) continue;
            temp[idx++]=arr[n-1-i][col];
        }
        
        for(int i=0; i<n;i++){
            arr[n-1-i][col]=temp[i];
        }
               
    }
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        row = sc.nextInt()-1;
        col = sc.nextInt()-1;

        boom();
        gravity();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();


    }
}
