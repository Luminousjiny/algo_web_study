package DP;

import java.util.Scanner;

public class BOJ2579 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] totalScore = new int[n+1];
		int[] stairPoint = new int[n+1];
		for(int i = 1; i <= n; i++) {
			stairPoint[i] = scanner.nextInt();
		}
		totalScore[1] = stairPoint[1];
		if(n > 1) {
			totalScore[2] = totalScore[1] + stairPoint[2];
			for(int i = 3; i <= n; i++) {
				totalScore[i] = Math.max(totalScore[i-2]+ stairPoint[i], 
						totalScore[i-3] + stairPoint[i-1]+ stairPoint[i]);
			}
		}
		System.out.println(totalScore[n]);
		scanner.close();
	}
}
