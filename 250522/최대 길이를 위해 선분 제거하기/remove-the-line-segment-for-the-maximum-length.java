import java.util.*;

public class Main {
    static class Segment {
        int x1, x2;
        public Segment(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Segment[] segments = new Segment[n];
        TreeSet<Integer> coordSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Segment(x1, x2);
            coordSet.add(x1);
            coordSet.add(x2);
        }

        // 좌표 압축
        List<Integer> coords = new ArrayList<>(coordSet);
        Map<Integer, Integer> compress = new HashMap<>();
        for (int i = 0; i < coords.size(); i++) {
            compress.put(coords.get(i), i);
        }

        int[] diff = new int[coords.size() + 2];
        for (Segment s : segments) {
            int l = compress.get(s.x1);
            int r = compress.get(s.x2);
            diff[l]++;
            diff[r]--;
        }

        // 누적합 계산
        int[] prefix = new int[coords.size() + 1];
        for (int i = 0; i < coords.size(); i++) {
            prefix[i] = (i == 0 ? 0 : prefix[i - 1]) + diff[i];
        }

        // 전체 길이 계산
        int total = 0;
        for (int i = 0; i < coords.size() - 1; i++) {
            if (prefix[i] > 0) {
                total += coords.get(i + 1) - coords.get(i);
            }
        }

        // 각 선분이 유일하게 덮는 구간만큼 길이를 체크
        int minRemove = Integer.MAX_VALUE;
        for (Segment s : segments) {
            int l = compress.get(s.x1);
            int r = compress.get(s.x2);
            int len = 0;
            for (int i = l; i < r; i++) {
                if (prefix[i] == 1) {
                    len += coords.get(i + 1) - coords.get(i);
                }
            }
            minRemove = Math.min(minRemove, len);
        }

        System.out.println(total - minRemove);
    }
}