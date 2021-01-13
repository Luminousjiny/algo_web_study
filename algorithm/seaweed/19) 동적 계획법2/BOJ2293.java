package day0114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2293 {
    static int N, K;
    static int[] coins, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        dp = new int[K + 1]; // dp[k] = k원을 만드는 동전 조합 수

        for (int i = 0; i < N; ++i) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int coin : coins) {
            if (coin > K) continue;
            for (int k = 1; k <= K; ++k) {
                if (coin > k) continue;
                dp[k] = (coin == k) ? dp[k] + 1 : dp[k] + dp[k - coin];
            }
        }
        System.out.println(dp[K]);
    }
}
