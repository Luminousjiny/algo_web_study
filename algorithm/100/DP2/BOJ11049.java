package DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11049 {
	static int[][] matrix;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		matrix = new int[N][2];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		System.out.println(solve(0, N - 1));
	}

	public static int solve(int start, int end) {
		if (start == end)
			return 0;
		if (dp[start][end] != Integer.MAX_VALUE) {
			return dp[start][end];
		}
		for (int i = start; i < end; i++) {
			int cost = solve(start, i) + solve(i + 1, end) + matrix[start][0] * matrix[i][1] * matrix[end][1];
			dp[start][end] = Math.min(dp[start][end], cost);
		}
		return dp[start][end];
	}

}
