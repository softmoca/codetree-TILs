import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Integer> answer = new ArrayList<>();
    static int res = Integer.MIN_VALUE;
    static int[] arr;

    static void choose(int currIdx, int start) {
        if (currIdx == m) {
            int temp = 0;
            for (int i = 0; i < answer.size(); i++) {
                temp = answer.get(i) ^ temp;
            }
            res = Math.max(res, temp);
return;
        }

        for (int i = start; i < n; i++) {
            if ((n - i + 1) < (m - currIdx)) {
                return;
            }

            answer.add(arr[i]);
            choose(currIdx + 1, i + 1);
            answer.remove(answer.size() - 1);

        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        choose(0, 0);
        System.out.println(res);
    }
}

