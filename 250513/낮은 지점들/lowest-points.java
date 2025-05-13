import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (map.containsKey(x)) {
                if (map.get(x) > y) {
                    map.put(x, y);
                }


            } else {
                map.put(x, y);
            }

        }

        long res = 0;
        for (int x : map.keySet()) {
            res += map.get(x);
        }
        System.out.println(res);

    }
}