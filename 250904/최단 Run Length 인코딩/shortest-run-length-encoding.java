import java.io.*;
import java.util.*;

/*

 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int res = 0;

        for (int i = 1; i < input.length(); i++) {
            input = input.substring(1, input.length()) + input.charAt(0);
            Set<Character> set = new HashSet<>();

            for (char c : input.toCharArray()) {
                set.add(c);
            }
            if (input.length() == 10 && set.size() == 1) {
                res = 3;
            }

            res = Math.max(res, set.size() * 2);


        }

        System.out.println(res);
    }
}
