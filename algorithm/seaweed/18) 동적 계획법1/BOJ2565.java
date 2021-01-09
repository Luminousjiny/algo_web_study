package day0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2565 {
    static int N, ans;
    static int[][] connections; // from -> to
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        ans = Integer.MIN_VALUE;
        dp = new int[N];
        connections = new int[N][2]; // [[from, to], [from, to], ... ]

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            connections[i][0] = Integer.parseInt(st.nextToken()); // from
            connections[i][1] = Integer.parseInt(st.nextToken()); // to
        }

        Arrays.sort(connections, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < N; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if(connections[j][1] < connections[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(N - ans);
    }
}
