package day0107;

import java.util.Scanner;

public class BOJ1463 {
	/*
	 * 1. 3으로 나눈다
	 * 2. 2로 나눈다
	 * 3. 1 뺀다
	 * 위 3개 연산을 최소한으로 이용해 주어진 수를 1로 만들기
	 */
	static int[] dp;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dp = new int[N + 1];
		
		for (int i = 2; i <= N; i++) {
			int currMin = Integer.MAX_VALUE;
			
			if (i % 3 == 0) {
				currMin = Math.min(currMin, dp[i / 3] + 1);
			}

			if (i % 2 == 0) {
				currMin = Math.min(currMin, dp[i / 2] + 1);
			}

			if (i > 1) {
				currMin = Math.min(currMin, dp[i - 1] + 1);
			}
			
			dp[i] = currMin;
		}
		
		System.out.println(dp[N]);
	}

}