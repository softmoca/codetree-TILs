import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int res = 0;

    static int[] go(int startIdx, int endIdx, int[] arr) {
        int[] temp = new int[arr.length];
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (i >= startIdx && i <= endIdx || arr[i] == 0) {
                continue;
            }

            ad.addLast(arr[i]);

        }
        int size = ad.size();
        for (int i = 0; i < size; i++) {
            temp[i] = ad.removeFirst();
        }

        res = size;

        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int t = 2;
        while (t-- > 0) {
            int startIdx = sc.nextInt() - 1;
            int endIdx = sc.nextInt() - 1;
            arr = go(startIdx, endIdx, arr);


        }

        System.out.println(res);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                break;
            }
            System.out.println(arr[i]);
        }


    }

    static int n;

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
