import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            char[] chars = names[i].toCharArray();  // 문자열 → 문자 배열
            Arrays.sort(chars);                     // 문자 배열 정렬
            names[i] = new String(chars);           // 다시 문자열로 변환
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(names[i], map.getOrDefault(names[i], 0) + 1);
        }

        int res = 0;
        for (String name : map.keySet()) {
            res = Math.max(res, map.get(name));
        }
        System.out.println(res);


    }
}
