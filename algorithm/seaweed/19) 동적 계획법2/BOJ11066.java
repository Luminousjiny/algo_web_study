package day0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11066 {
    static int TC, K;
    static int[][] dp;
    static int[] cost, subSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; ++tc) {
            K = Integer.parseInt(br.readLine());
            cost = new int[K + 1];
            subSum = new int[K + 1];
            dp = new int[K + 1][K + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int k = 1; k <= K; ++k) {
                cost[k] = Integer.parseInt(st.nextToken());
                subSum[k] += (subSum[k - 1] + cost[k]);
            }

            for (int k = 0; k <= K; ++k) {
                Arrays.fill(dp[k], Integer.MAX_VALUE);
            }
            sb.append(solve(1, K)).append('\n');
        } // 테스트 케이스 끝
        System.out.println(sb.toString());
    }

    static int solve(int start, int end) {
        if (dp[start][end] != Integer.MAX_VALUE) return dp[start][end];
        if(start == end) return 0; // 챕터 하나만 선택한 경우

        for (int i = start; i < end; ++i) {
            dp[start][end] = Math.min(dp[start][end], solve(start, i) + solve(i + 1, end) + subSum[end] - subSum[start - 1]);
        }
        return dp[start][end];
    }
}
