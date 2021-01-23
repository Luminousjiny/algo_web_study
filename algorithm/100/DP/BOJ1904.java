package DP;

import java.util.Scanner;

public class BOJ1904 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		int [] dp = new int[1000001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <=N; i++)dp[i] =(dp[i-2] + dp[i-1])%15746;
		System.out.println(dp[N]);
	}
}
