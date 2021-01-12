package DP;

import java.util.Scanner;

public class BOJ2516 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int p[] = new int[n + 1];
		int dp[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			p[i] = scanner.nextInt();
		}
		if (n >= 1) {
			dp[1] = p[1];
		}
		if (n >= 2) {
			dp[2] = p[1] + p[2];
		}

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + p[i], dp[i - 3] + p[i - 1] + p[i]));
		}
		System.out.println(dp[n]);
		scanner.close();
	}
}
