import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> answer = new ArrayList<>();
    static int k;
    static int n;

    static void c(int currIdx) {

        if (currIdx == n + 1) {
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            answer.add(i);
            c(currIdx + 1);
            answer.remove(answer.size() - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        c(1);


    }
}
