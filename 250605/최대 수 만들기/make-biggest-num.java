import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums, Comparator
                .comparing((Integer a) -> String.valueOf(a),
                        (x, y) -> (y + x).compareTo(x + y)));

        StringBuilder result = new StringBuilder();
        for (Integer num : nums) {
            result.append(num);
        }

        if (result.charAt(0) == '0') {
            System.out.println(0);
        } else {
            System.out.println(result.toString());
        }
    }
}
