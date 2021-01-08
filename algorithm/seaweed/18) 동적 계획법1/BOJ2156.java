package day0108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
    /**
     * dp[i] = i번째 잔까지 마실 수 있는 와인 최대량
     * 연속 3잔은 마실 수 없다.
     */
    static int N;
    static int[] dp, wines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        wines = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; ++i) {
            if (i < 3) {
                dp[i] = dp[i - 1] + wines[i];
            } else {
                dp[i] = Math.max(Math.max(dp[i - 3] + wines[i - 1] + wines[i], dp[i - 2] + wines[i]), dp[i - 1]);
            }
        }
        System.out.println(dp[N]);
    }
}
