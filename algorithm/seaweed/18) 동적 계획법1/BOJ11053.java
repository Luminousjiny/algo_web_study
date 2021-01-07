package day0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
    static int N, ans;
    static int[] dp, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ans = 0;
        dp = new int[N + 1];
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < i; ++j) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        System.out.println(ans);
    }
}
