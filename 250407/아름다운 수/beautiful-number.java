import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> answer = new ArrayList<>();
    static int n;
    static int res = 0;

    static boolean isBeauty() {
        for (int i = 0; i < n; i++) {
            int target = answer.get(i);

            for (int j = i; j < i + (target - 1); j++) {
                if (j >= n - 1) {
                    return false;
                }

                if (answer.get(j) != answer.get(j + 1)) {
                    return false;
                }
            }
            i = i + target - 1;
        }
        return true;
    }

    static void c(int currIdx) {

        if (currIdx == n + 1) {
            if (isBeauty()) {
                res++;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            answer.add(i);
            c(currIdx + 1);
            answer.remove(answer.size() - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        c(1);
        System.out.println(res);

    }
}
