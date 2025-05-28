import java.util.Scanner;
import java.util.TreeSet;
import java.util.Arrays;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;        // x 기준 오름차순 정렬
    }
}

class TargetPoint implements Comparable<TargetPoint> {
    int x, y;

    public TargetPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(TargetPoint p) {
        if(this.y != p.y)
            return this.y - p.y;                // y 기준 오름차순 정렬
        return this.x - p.x;                    // y가 동일할시 x 기준 오름차순 정렬
    }
}

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, d;
    public static Point[] point = new Point[MAX_N + 1];
    public static TreeSet<TargetPoint> pointCount = new TreeSet<>();
    
    public static int getMin() {
        if(pointCount.isEmpty()) return 0;
        return pointCount.first().y; 
    }
    
    public static int getMax() {
        if(pointCount.isEmpty()) return 0;
        return pointCount.last().y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        d = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            point[i] = new Point(x, y);
        }

        // x좌표 기준 오름차순 정렬을 진행합니다.
        Arrays.sort(point, 1, n + 1);

        // 가능한 구간 중 최소 크기를 구합니다.
        int ans = INT_MAX;

        // 구간을 잡아봅니다.
        int j = 0;
        for(int i = 1; i <= n; i++) {
            // y좌표 차가 d가 되기 전까지 계속 진행합니다.
            while(j + 1 <= n && getMax() - getMin() < d) {
                pointCount.add(new TargetPoint(point[j + 1].x, point[j + 1].y));
                j++;
            }

            // 만약 최대한 이동했는데도
            // y좌표 차가 d가 되지 못했다면
            // 탐색을 종료합니다.
            if(getMax() - getMin() < d)
                break;

            // 현재 구간 [i, j]는 
            // point[i]를 시작점으로 하는
            // 가장 짧은 구간이므로
            // 구간 크기 중 최솟값을 갱신합니다.
            ans = Math.min(ans, point[j].x - point[i].x);
            
            // 다음 구간으로 넘어가기 전에
            // point[i]에 해당하는 값은 pointCount에서 지워줍니다.
            pointCount.remove(new TargetPoint(point[i].x, point[i].y));
        }

        // 만약 불가능하다면
        // -1을 답으로 합니다.
        if(ans == INT_MAX) System.out.print(-1);
        else System.out.print(ans);
    }
}
