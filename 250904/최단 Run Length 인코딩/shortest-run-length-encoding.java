import java.io.*;
import java.util.*;

/*

 */


public class Main {
    static int res = 10000;

    static void go(String input) {

        int cnt = 1;
        String temp = "";

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                cnt++;
            } else {
                temp = temp + input.charAt(i - 1);
                temp = temp + String.valueOf(cnt);
                cnt = 1;
            }
        }

        temp = temp + input.charAt(input.length() - 1);
        temp = temp + String.valueOf(cnt);
        res = Math.min(res, temp.length());
        //System.out.println(temp.length());


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();


        for (int i = 0; i < input.length(); i++) {
            input = input.substring(1, input.length()) + input.charAt(0);


            go(input);


        }

        System.out.println(res);
    }
}
