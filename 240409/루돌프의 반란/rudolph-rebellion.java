import java.util.*;
import java.io.*;

public class Main {
    static int N, M, P, C, D;
    static int[][] v;
    static int[] score, alive, wakeup_turn;
    static int[][] santa;
    static int ri, rj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        v = new int[N][N];
        score = new int[P+1];
        alive = new int[P+1];
        wakeup_turn = new int[P+1];
        santa = new int[P+1][2];

        st = new StringTokenizer(br.readLine());
        ri = Integer.parseInt(st.nextToken()) - 1;
        rj = Integer.parseInt(st.nextToken()) - 1;
        v[ri][rj] = -1;

        for (int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken()) - 1;
            int sj = Integer.parseInt(st.nextToken()) - 1;
            santa[n] = new int[]{si, sj};
            v[si][sj] = n;
        }

        for (int turn = 1; turn <= M; turn++) {
            if (Arrays.stream(alive).sum() == 0) break;

            int mn = 2 * N * N;
            List<int[]> mlst = new ArrayList<>();
            for (int idx = 1; idx <= P; idx++) {
                if (alive[idx] == 0) continue;

                int si = santa[idx][0];
                int sj = santa[idx][1];
                int dist = (ri - si) * (ri - si) + (rj - sj) * (rj - sj);
                if (mn > dist) {
                    mn = dist;
                    mlst = new ArrayList<>();
                    mlst.add(new int[]{si, sj, idx});
                } else if (mn == dist) {
                    mlst.add(new int[]{si, sj, idx});
                }
            }

            mlst.sort((a, b) -> {
                if (b[0] != a[0]) return b[0] - a[0];
                else return b[1] - a[1];
            });

            int[] target = mlst.get(0);
            int si = target[0];
            int sj = target[1];
            int mn_idx = target[2];

            int rdi = 0, rdj = 0;
            if (ri > si) rdi = -1;
            else if (ri < si) rdi = 1;
            if (rj > sj) rdj = -1;
            else if (rj < sj) rdj = 1;

            v[ri][rj] = 0;
            ri += rdi;
            rj += rdj;
            v[ri][rj] = -1;

            if (ri == si && rj == sj) {
                score[mn_idx] += C;
                wakeup_turn[mn_idx] = turn + 2;
                move_santa(mn_idx, si, sj, rdi, rdj, C);
            }

            for (int idx = 1; idx <= P; idx++) {
                if (alive[idx] == 0 || wakeup_turn[idx] > turn) continue;

                si = santa[idx][0];
                sj = santa[idx][1];
                int mn_dist = (ri - si) * (ri - si) + (rj - sj) * (rj - sj);
                List<int[]> tlst = new ArrayList<>();

                for (int[] d : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                    int ni = si + d[0];
                    int nj = sj + d[1];
                    if (ni < 0 || ni >= N || nj < 0 || nj >= N || v[ni][nj] > 0) continue;

                    int dist = (ri - ni) * (ri - ni) + (rj - nj) * (rj - nj);
                    if (mn_dist > dist) {
                        mn_dist = dist;
                        tlst = new ArrayList<>();
                        tlst.add(new int[]{ni, nj, d[0], d[1]});
                    }
                }

                if (tlst.size() == 0) continue;
                int[] t = tlst.get(tlst.size() - 1);
                int ni = t[0];
                int nj = t[1];
                int di = t[2];
                int dj = t[3];

                if (ri == ni && rj == nj) {
                    score[idx] += D;
                    wakeup_turn[idx] = turn + 2;
                    v[si][sj] = 0;
                    move_santa(idx, ni, nj, -di, -dj, D);
                } else {
                    v[si][sj] = 0;
                    v[ni][nj] = idx;
                    santa[idx] = new int[]{ni, nj};
                }
            }

            for (int i = 1; i <= P; i++) {
                if (alive[i] == 1) score[i]++;
            }
        }

        for (int i = 1; i <= P; i++) {
            System.out.print(score[i] + " ");
        }
    }

    static void move_santa(int cur, int si, int sj, int di, int dj, int mul) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{cur, si, sj, mul});

        while (!q.isEmpty()) {
            int[] t = q.poll();
            cur = t[0];
            int ci = t[1];
            int cj = t[2];
            mul = t[3];

            int ni = ci + di * mul;
            int nj = cj + dj * mul;
            if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
                alive[cur] = 0;
                return;
            }

            if (v[ni][nj] == 0) {
                v[ni][nj] = cur;
                santa[cur] = new int[]{ni, nj};
                return;
            } else {
                q.add(new int[]{v[ni][nj], ni, nj, 1});
                v[ni][nj] = cur;
                santa[cur] = new int[]{ni, nj};
            }
        }
    }
}