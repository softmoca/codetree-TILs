import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int n = a.length(), m = b.length();
        boolean[][] isPos = new boolean[25][25]; // 매칭 가능 여부를 저장하는 배열을 초기화합니다.

        // 문자열 a와 b를 비교하여 정규 표현식 패턴에 맞는지 확인합니다.
        a = " " + a; // 인덱스 접근을 편리하게 하기 위해 문자열 앞에 공백을 추가합니다.
        b = " " + b;

        isPos[0][0] = true; // 초기 상태를 참으로 설정합니다.

        // isPos[i][j] :: 문자열 a의 i번째와 표현식 b의 j번째까지가 서로 일치하면 true, 아니면 false
        for (int j = 0; j < m; j++) {
            for (int i = 0; i <= n; i++) {


                // 현재 상태(i, j)가 불가능하다면 건너뜀
                if (!isPos[i][j]) continue;

                // 다음 문자가 '*' 인 경우 (ex: a* , .* )
                if (j != m - 1 && b.charAt(j + 2) == '*') {
                    // '*' 는 해당 문자가 0번 등장하는 경우도 가능하므로
                    // 현재 위치에서 곧바로 j+2로 점프 가능
                    isPos[i][j + 2] = true;

                    // 이후 문자열 a에서 현재 문자(b[j+1])가 반복되는 경우
                    // 반복해서 매칭을 진행 (최대 n까지 탐색)
                    for (int curi = i + 1; curi <= n; curi++) {
                        // '.' 가 아닌데 현재 문자가 다르면 반복 불가능 → 종료
                        if (b.charAt(j + 1) != '.' && a.charAt(curi) != b.charAt(j + 1)) break;
                        // 반복이 유효하면 해당 위치도 매칭 성공 처리
                        isPos[curi][j + 2] = true;
                    }

                    // 패턴이 '.' 인 경우 (임의의 한 문자 매칭)
                } else if (b.charAt(j + 1) == '.') {
                    isPos[i + 1][j + 1] = true;

                    // 일반 문자인 경우
                } else {
                    // 문자열 a의 현재 문자와 패턴 문자가 동일해야 함
                    if (i != n && a.charAt(i + 1) == b.charAt(j + 1))
                        isPos[i + 1][j + 1] = true;
                }



            }
        }

        // 최종적으로 문자열 'a'와 'b'가 정규 표현식 패턴에 따라 일치하는지 결과를 출력합니다.
        System.out.println(isPos[n][m] ? "true" : "false");
    }
}
