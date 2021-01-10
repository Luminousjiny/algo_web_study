package day0110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {
    static int N, ANS;
    static int[] nums;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[2][N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // -> 방향
        for (int i = 0; i < N; ++i) {
            dp[0][i] = 1;
            for (int j = 0; j < i; ++j) {
                if(nums[j] < nums[i])
                    dp[0][i] = Math.max(dp[0][j] + 1, dp[0][i]);
            }
        }
        // <- 방향
        for (int i = N - 1; i >= 0; --i) {
            dp[1][i] = 1;
            for (int j = N - 1; j > i; --j) {
                if(nums[j] < nums[i])
                    dp[1][i] = Math.max(dp[1][j] + 1, dp[1][i]);
            }
        }

        // 가장 긴 바이토닉 수열 길이 구하기
        ANS = 0;
        for (int i = 0; i < N; ++i) {
            ANS = Math.max(ANS, dp[0][i] + dp[1][i] - 1);
        }

        System.out.println(ANS);
    }
}
