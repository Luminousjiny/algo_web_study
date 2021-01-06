package day0106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
    static int N;
    static int[] scores;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        scores = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < N + 1; ++i) {
            if (i < 3) { // 계단이 3칸 미만이라면 전부 밟고 올라가는게 가장 점수 높음
                dp[i] = dp[i - 1] + scores[i];
            } else {
                dp[i] = Math.max(scores[i] + scores[i - 1] + dp[i - 3], scores[i] + dp[i - 2]);
            }
        }

        System.out.println(dp[N]);
    }
}
