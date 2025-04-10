import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int sum;
    static List<Integer> answer = new ArrayList<>();
    static int res = Integer.MAX_VALUE;

    static void choose(int currIdx, int start) {

        if (currIdx == n) {
            int tempSum = 0;

            for (int x : answer) {
              //  System.out.print(x + " ");
                tempSum += arr[x];
            }
            //  System.out.println();
            //System.out.println("tempSum " + tempSum + " Sum " + sum + " res " + (sum - tempSum));
            res = Math.min(res, Math.abs((sum - tempSum) - tempSum));


            return;
        }

        for (int i = start; i < 2 * n; i++) {
            answer.add(i);
            choose(currIdx + 1, i + 1);
            answer.remove(answer.size() - 1);
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[2 * n];
        sum = 0;
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }


        choose(0, 0);
        System.out.println(res);

    }
}
