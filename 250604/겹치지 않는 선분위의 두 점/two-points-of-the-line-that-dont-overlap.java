import java.util.Scanner;
import java.util.Arrays;

class Pair implements Comparable<Pair> { 
    long a, b;
    public Pair(long a, long b) { 
        this.a = a; 
        this.b = b; 
    }
    @Override
    public int compareTo(Pair other) {
        if(a > other.a) return 1;
        if(a < other.a) return -1;

        if(b > other.b) return 1;
        return -1;
    }
}

public class Main {
    public static final long MAX_NUM = (long)1e18;
    public static final int MAX_M = 100000;
    
    // 변수 선언
    public static int n, m;
    public static Pair[] segments = new Pair[MAX_M];
    
    // 가장 가까운 두 점 사이의 거리를 dist로 제한 한다고 했을 때
    // 점을 n개 놓을 수 있을지를 판단합니다.
    public static boolean isPossible(long dist) {
        // 놓을 수 있는 점의 수를 게산합니다.
        // dist가 정해져 있는 이상
        // 최대한 좌측으로 밀착하여 점을 놓아주는 것이 좋습니다.
        int cnt = 0;
        long lastX = -MAX_NUM;
        for(int i = 0; i < m; i++) {
            long a = segments[i].a;
            long b = segments[i].b;
            // 현재 선분에 점을 계속 놓을 수 있을 때까지
            // 점을 추가하고, 마지막으로 놓은 점의 위치를 갱신해줍니다.
            while(lastX + dist <= b) {
                cnt++;
                lastX = Math.max(a, lastX + dist);

               // if(cnt >= n)
                   // break;
            }
        }
    
        // 놓을 수 있는 점의 개수가 n개 이상이라면 true
        // 아니라면 불가능한 것이므로 false를 반환합니다.
        return cnt >= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            segments[i] = new Pair(a, b);
        }

        // 선분의 시작점을 기준으로 오름차순 정렬을 진행합니다.
        Arrays.sort(segments, 0, m);
        
        long left = 1;                          // 답이 될 수 있는 가장 작은 숫자 값을 설정합니다.
        long right = MAX_NUM;                   // 답이 될 수 있는 가장 큰 숫자 값을 설정합니다.
        long ans = 0;                           // 답을 저장합니다.
        
        while (left <= right) {                      // [left, right]가 유효한 구간이면 계속 수행합니다.
            long mid = (left + right) / 2;      // 가운데 위치를 선택합니다.
            if(isPossible(mid)) {                    // 결정문제에 대한 답이 Yes라면
                left = mid + 1;                      // 오른쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 left를 바꿔줍니다.
                ans = Math.max(ans, mid);                 // 답의 후보들 중 최댓값을 계속 갱신해줍니다.
            }
            else                               
                right = mid - 1;                     // 결정문제에 대한 답이 No라면 right를 바꿔줍니다.
        }

        System.out.print(ans);
    }
}
