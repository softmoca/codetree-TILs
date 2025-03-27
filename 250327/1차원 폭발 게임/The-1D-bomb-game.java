import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    //static int[] temp;
    static int checkIdx;

    static void gravity() {
        int[] temp = new int[checkIdx];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[idx++] = arr[i];
            }
        }
        checkIdx = idx;

        arr = temp;
    }

    static boolean boom() {
        int len = arr.length;

        int cnt = 1;
        boolean flag = false;
        for (int i = 0; i < checkIdx - 1; i++) {
            if (arr[i] != arr[i + 1]) {

                if (cnt >= m) {
                    flag = true;
                    for (int j = 0; j < cnt; j++) {
                        arr[i - j] = 0;
                    }
                }
                cnt = 1;

            } else {
                cnt++;
            }

        }

        if (cnt >= m) {
            flag = true;
            for (int j = 0; j < cnt; j++) {
                arr[checkIdx - 1 - j] = 0;
            }

        }

        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        checkIdx = n;
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        while (boom()) {
            gravity();
        }
        if(m==1){
            System.out.println(0);
            System.exit(0);
        }
        

        System.out.println(checkIdx);

        for (int i = 0; i < checkIdx; i++) {
            System.out.println(arr[i]);
        }


    }
}
