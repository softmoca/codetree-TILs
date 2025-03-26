import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int n;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();



        int[][] arr = new int[n][n];

        initArray(sc, arr);

        int startx=sc.nextInt()-1;
        int starty=sc.nextInt()-1;
        int[] dirArr=new int[4];
        dirArr[0]=sc.nextInt();
        dirArr[1]=sc.nextInt();
        dirArr[2]=sc.nextInt();
        dirArr[3]=sc.nextInt();

        int dir=sc.nextInt();
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        if(dir==0){// 반시계
            ad.addLast(arr[startx][starty]);
            for(int i=0; i<dirArr[0];i++){
                startx=startx-1;
                starty=starty+1;
                ad.addLast(arr[startx][starty]);
            }
            for(int i=0; i<dirArr[1];i++){
                startx=startx-1;
                starty=starty-1;
                ad.addLast(arr[startx][starty]);
            }
            for(int i=0; i<dirArr[2];i++){
                startx=startx+1;
                starty=starty-1;
                ad.addLast(arr[startx][starty]);
            }
            for(int i=0; i<dirArr[3]-1;i++){
                startx=startx+1;
                starty=starty+1;
                ad.addLast(arr[startx][starty]);
            }
            ad.addFirst(ad.removeLast());
            startx=startx+1;
            starty=starty+1;
            /////
            arr[startx][starty]=ad.removeFirst();
            for(int i=0; i<dirArr[0];i++){
                startx=startx-1;
                starty=starty+1;
                arr[startx][starty]=ad.removeFirst();
            }
            for(int i=0; i<dirArr[1];i++){
                startx=startx-1;
                starty=starty-1;
                arr[startx][starty]=ad.removeFirst();
            }
            for(int i=0; i<dirArr[2];i++){
                startx=startx+1;
                starty=starty-1;
                arr[startx][starty]=ad.removeFirst();
            }
            for(int i=0; i<dirArr[3]-1;i++){
                startx=startx+1;
                starty=starty+1;
                arr[startx][starty]=ad.removeFirst();
            }


        }else{ //시계


            ad.addLast(arr[startx][starty]);
            for(int i=0; i<dirArr[0];i++){
                startx=startx-1;
                starty=starty+1;
                ad.addLast(arr[startx][starty]);
            }
            for(int i=0; i<dirArr[1];i++){
                startx=startx-1;
                starty=starty-1;
                ad.addLast(arr[startx][starty]);
            }
            for(int i=0; i<dirArr[2];i++){
                startx=startx+1;
                starty=starty-1;
                ad.addLast(arr[startx][starty]);
            }
            for(int i=0; i<dirArr[3]-1;i++){
                startx=startx+1;
                starty=starty+1;
                ad.addLast(arr[startx][starty]);
            }

            ad.addLast(ad.removeFirst());
            ///
            startx=startx+1;
            starty=starty+1;
            arr[startx][starty]=ad.removeFirst();
            for(int i=0; i<dirArr[3];i++){
                startx=startx-1;
                starty=starty-1;
                arr[startx][starty]=ad.removeFirst();
            }
            for(int i=0; i<dirArr[2];i++){
                startx=startx-1;
                starty=starty+1;
                arr[startx][starty]=ad.removeFirst();
            }
            for(int i=0; i<dirArr[1];i++){
                startx=startx+1;
                starty=starty+1;
                arr[startx][starty]=ad.removeFirst();
            }
            for(int i=0; i<dirArr[0]-1;i++){
                startx=startx+1;
                starty=starty-1;
                arr[startx][starty]=ad.removeFirst();
            }





        }







        printArray(arr);
    }

    static void initArray(Scanner sc, int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }

    static void printArray(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
