import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] matches = new char[n + 1];
        for (int i = 1; i <= n; i++) {
            char x = sc.next().charAt(0);
            if (x == 'P') {
                x = 'p';
            } else if (x == 'H') {
                x = 'h';
            } else {
                x = 's';
            }

            matches[i] = x;
        }

        int[] hl = new int[n + 2];
        int[] hr = new int[n + 2];
        int[] sl = new int[n + 2];
        int[] sr = new int[n + 2];
        int[] pl = new int[n + 2];
        int[] pr = new int[n + 2];

        for (int i = 1; i <= n; i++) {// 주먹 l
            if (matches[i] == 's') {
                hl[i] = hl[i - 1] + 1;
            } else {
                hl[i] = hl[i - 1];
            }
        }

        for (int i = n; i > 0; i--) { // 주먹 r
            if (matches[i] == 's') {
                hr[i] = hr[i + 1] + 1;
            } else {
                hr[i] = hr[i + 1];
            }
        }


        for (int i = 1; i <= n; i++) {// 가위 l
            if (matches[i] == 'p') {
                sl[i] = sl[i - 1] + 1;
            } else {
                sl[i] = sl[i - 1];
            }
        }


        for (int i = n; i > 0; i--) { // 가위 r
            if (matches[i] == 'p') {
                sr[i] = sr[i + 1] + 1;
            } else {
                sr[i] = sr[i + 1];
            }
        }


        for (int i = 1; i <= n; i++) {// 보자기 l
            if (matches[i] == 'h') {
                pl[i] = pl[i - 1] + 1;
            } else {
                pl[i] = pl[i - 1];
            }
        }


        for (int i = n; i > 0; i--) { // 보자기 r
            if (matches[i] == 'h') {
                pr[i] = pr[i + 1] + 1;
            } else {
                pr[i] = pr[i + 1];
            }
        }


        int res = 0;
        for (int i = 0; i < n; i++) { // 주 -> 가
            res = Math.max(hl[i] + sr[i + 1], res);
        }

        for (int i = 0; i < n; i++) { // 주 -> 보
            res = Math.max(hl[i] + pr[i + 1], res);
        }

        for (int i = 0; i < n; i++) {// 가 -> 주
            res = Math.max(sl[i] + hr[i + 1], res);
        }

        for (int i = 0; i < n; i++) { // 가 -> 보
            res = Math.max(sl[i] + pr[i + 1], res);
        }

        for (int i = 0; i < n; i++) { // 보 -> 바
            res = Math.max(pl[i] + hr[i + 1], res);
        }

        for (int i = 0; i < n; i++) { // 보 -> 가
            res = Math.max(pl[i] + sr[i + 1], res);
        }
        System.out.println(res);

        // Please write your code here.
    }
}