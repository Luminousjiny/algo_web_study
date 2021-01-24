package day0124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11049 {
    static int N;
    static int[][] matrices, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        matrices = new int[N + 1][2];
        dp = new int[N + 1][N + 1]; // dp[i][j] : i ~ j 까지 행렬 곱 연산 최소 횟수

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            matrices[i][0] = Integer.parseInt(st.nextToken());
            matrices[i][1] = Integer.parseInt(st.nextToken());

            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(1, N));
    }

    static int solve(int start, int end) {
        if (start == end) return 0;
        if (dp[start][end] != -1) return dp[start][end]; // 중간 연산값이 Integer.MAX_VALUE값과 같을 수 있기 때문에 음수를 이용해 확인 여부 체크

        dp[start][end] = Integer.MAX_VALUE;

        for (int i = start; i < end; ++i) {
            dp[start][end] = Math.min(dp[start][end], solve(start, i) + solve(i + 1, end) + matrices[start][0] * matrices[i][1] * matrices[end][1]);
        }
        return  dp[start][end];
    }
}
