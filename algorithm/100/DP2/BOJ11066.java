package DP2;
import java.util.Scanner;

public class BOJ11066 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 0; test < T; test++) {
			int K = sc.nextInt();
			int[] sum = new int[K + 1];
			int[][] dp = new int[502][502];
			for (int i = 1; i <= K; i++) {
				sum[i] = sum[i - 1] + sc.nextInt();
			}
			for (int i = 2; i <= K; i++) {
				for (int j = i - 1; j > 0; j--) {
					dp[j][i] = Integer.MAX_VALUE;
					for (int s = j; s <= i; s++)
						dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s + 1][i]);
					dp[j][i] += sum[i] - sum[j - 1];
				}
			}
			System.out.println(dp[1][K]);
		}
		sc.close();
	}

}