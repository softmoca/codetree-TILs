import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt();

int cnt=1;
for(int i=0;i<n;i++ ){

    if( i%2==0){
        for(int j=0;j<n j++){
            System.out.print(cnt+" ");
                 cnt++;
        }
        cnt=cnt+n-1;

    }else{
              for(int j=0;j<n j++){
             
            System.out.print(cnt+" ");
            cnt--;
        }
        cnt=cnt+n=1;



    }
    System.out.println();



}


    }
}