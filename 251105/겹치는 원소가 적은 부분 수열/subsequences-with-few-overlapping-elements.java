import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        // 1) 좌표 압축 준비
        int[] compSrc = a.clone();
        Arrays.sort(compSrc);
        int m = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 || compSrc[i] != compSrc[i-1]) compSrc[m++] = compSrc[i];
        }
        // compSrc[0..m-1]에 고유값 정렬 저장

        // 2) a를 압축 인덱스로 변환
        int[] idx = new int[N];
        for (int i = 0; i < N; i++) {
            idx[i] = Arrays.binarySearch(compSrc, 0, m, a[i]); // 0..m-1 반환
        }

        // 3) 배열로 빈도 관리 + 슬라이딩 윈도우
        int[] freq = new int[m];
        int ans = 0, l = 0;
        for (int r = 0; r < N; r++) {
            int vr = idx[r];
            freq[vr]++;

            while (freq[vr] > K) {           // 조건 위반 시 왼쪽 축소
                int vl = idx[l];
                freq[vl]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        System.out.println(ans);
    }
}
