package day0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    static int MAX_SUM, MAX_VAL, N;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        MAX_VAL = Integer.MIN_VALUE;
        MAX_SUM = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            MAX_VAL = Math.max(MAX_VAL, arr[i]); // 음수만 있을 경우 방지하기 위해 값 중 최대값 저장해둠

            dp[i] = i == 0 ? arr[i] : Math.max(dp[i - 1] + arr[i], 0);
            MAX_SUM = Math.max(MAX_SUM, dp[i]);
        }

        System.out.println(MAX_SUM == 0 ? MAX_VAL : MAX_SUM);
    }
}
