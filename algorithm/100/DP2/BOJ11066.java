package DP2;

import java.util.Scanner;

public class BOJ11066 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		for (int tc = 0; tc < testCase; tc++) {
			int K = scanner.nextInt();
			int[] sum = new int[K + 1];
			int[][] dp = new int[K+1][K+1];
			for (int i = 1; i <= K; i++) {
				sum[i] = sum[i - 1] + scanner.nextInt();
			}

			for (int a = 1; a < K; a++) {
				for (int b = 1; a + b <= K; b++) {
					dp[b][a + b] = Integer.MAX_VALUE;
					for (int c = b; c < a + b; c++) {
						dp[b][a + b] = Math.min(dp[b][a + b], dp[b][c] + dp[c + 1][a + b]);
					}
					dp[b][a + b] += sum[a + b] - sum[b - 1];
				}
			}

			System.out.println(dp[1][K]);
		}
		scanner.close();
	}

}