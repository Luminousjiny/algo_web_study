package day0114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520_Dfs {

    static int M, N; // 행, 열 (M x N)
    static int[][] map;
    static int[][] dp;
    static int[] di = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N]; // 지도
        dp = new int[M][N]; // dp[i][j] : i행 j열 위치에서 목적지까지 갈 수 있는 경우의 수

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dfs(0, 0);

        System.out.println(dp[0][0]);
    }

    static class Point {
        int i, j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int dfs(int si, int sj) {
        if (si == M - 1 && sj == N - 1) {
            dp[si][sj] = 1;
            return dp[si][sj];
        }

        if (dp[si][sj] == -1) {
            dp[si][sj] = 0;
            for (int d = 0; d < 4; ++d) {
                int ni = si + di[d];
                int nj = sj + dj[d];

                if (canGo(si, sj, ni, nj)) {
                    dp[si][sj] += dfs(ni, nj);
                }
            }
        }

        return dp[si][sj];
    }

    static boolean canGo(int si, int sj, int ni, int nj) {
        return ni >= 0 && ni < M && nj >= 0 && nj < N && map[ni][nj] < map[si][sj];
    }
}
