package day0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[3][N + 1];

        for (int i = 1; i <= N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + Integer.parseInt(st.nextToken());
            dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + Integer.parseInt(st.nextToken());
            dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.min(Math.min(dp[0][N], dp[1][N]), dp[2][N]));
    }
}
