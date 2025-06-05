import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.next();
        }

        Arrays.sort(nums, Comparator
                .comparing((String a) -> a, (x, y) -> (y + x).compareTo(x + y)));


        StringBuilder result = new StringBuilder();
        for (String num : nums) {
            result.append(num);
        }

        // 0이 여러 개일 때 "0000"처럼 나오는 경우 처리
        if (result.charAt(0) == '0') {
            System.out.println(0);
        } else {
            System.out.println(result.toString());
        }
    }
}
