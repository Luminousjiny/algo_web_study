package day0106;

import java.util.Scanner;

public class BOJ1904 {
    /**
     * 1 <= N <= 1,000,000
     * dp[N] = dp[N-1] + dp[N-2]
     */
    static int N;
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[N]);
    }
}
