import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int[][] nextArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        if(m==1){
            System.out.println(0);
            System.exit(0);
        }
        
        int k = sc.nextInt();
        arr = new int[n][n];
        nextArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        while (k-- > 0) {
            //1. 폭탄 터짐
            //1-1. 열마다 m개 이상 연속된거 0 으로 체크 및 0으로 체크 되는지 확인
            // nextArr 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nextArr[i][j] = 0;
                }
            }
            boolean flag = true;

            while (flag) {
                flag = false;

                for (int col = 0; col < n; col++) {
                    int cnt = 1;
                    for (int row = 0; row < n - 1; row++) {
                        if (arr[row][col] != 0 && arr[row][col] != arr[row + 1][col]) {

                            if (cnt >= m) {
                                flag = true;
                                for (int i = 0; i < cnt; i++) {
                                    arr[row - i][col] = 0;
                                }
                            }

                            cnt = 1;

                        } else if (arr[row][col] != 0 && arr[row][col] == arr[row + 1][col]) {
                            cnt++;
                        }

                    }

                    if (cnt >= m) {
                        flag = true;
                        for (int i = 0; i < cnt; i++) {
                            arr[n - 1 - i][col] = 0;
                        }

                    }

                }

                //1-2 2차원 중력 적용

                for (int col = 0; col < n; col++) {
                    int nextRow = n - 1;
                    for (int row = nextRow; row >= 0; row--) {
                        if (arr[row][col] > 0) {
                            nextArr[nextRow--][col] = arr[row][col];
                        }
                    }
                }
                // nextArr -> arr로 copy
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = nextArr[i][j];
                    }
                }

                // nextArr 초기화
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        nextArr[i][j] = 0;
                    }
                }
            }

            //2. 회전
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    nextArr[col][n - 1 - row] = arr[row][col];
                }
            }
            // nextArr -> arr로 copy
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = nextArr[i][j];
                }
            }

            //3. 2차원 배열전체 중력 적용

            // nextArr 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nextArr[i][j] = 0;
                }
            }

            for (int col = 0; col < n; col++) {
                int nextRow = n - 1;
                for (int row = nextRow; row >= 0; row--) {
                    if (arr[row][col] > 0) {
                        nextArr[nextRow--][col] = arr[row][col];
                    }
                }
            }
            // nextArr -> arr로 copy
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = nextArr[i][j];
                }
            }


        }

        // nextArr 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextArr[i][j] = 0;
            }
        }
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int col = 0; col < n; col++) {
                int cnt = 1;
                for (int row = 0; row < n - 1; row++) {
                    if (arr[row][col] != 0 && arr[row][col] != arr[row + 1][col]) {

                        if (cnt >= m) {
                            flag = true;
                            for (int i = 0; i < cnt; i++) {
                                arr[row - i][col] = 0;
                            }
                        }

                        cnt = 1;

                    } else if (arr[row][col] != 0 && arr[row][col] == arr[row + 1][col]) {
                        cnt++;
                    }

                }

                if (cnt >= m) {
                    flag = true;
                    for (int i = 0; i < cnt; i++) {
                        arr[n - 1 - i][col] = 0;
                    }

                }

            }

            //1-2 2차원 중력 적용

            for (int col = 0; col < n; col++) {
                int nextRow = n - 1;
                for (int row = nextRow; row >= 0; row--) {
                    if (arr[row][col] > 0) {
                        nextArr[nextRow--][col] = arr[row][col];
                    }
                }
            }
            // nextArr -> arr로 copy
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = nextArr[i][j];
                }
            }

            // nextArr 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nextArr[i][j] = 0;
                }
            }


        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 0) {
                    res++;
                }

                //     System.out.print(arr[i][j] + " ");
            }
            //   System.out.println();
        }
        System.out.println(res);

    }


}