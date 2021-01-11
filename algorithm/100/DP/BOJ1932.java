package DP;

import java.util.*;

public class BOJ1932 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] array = new int[n + 1][n + 1];
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				array[i][j] = scanner.nextInt();
				if (j == 1) {
					array[i][j] = array[i - 1][j] + array[i][j];
				} else if (i == j) {
					array[i][j] = array[i - 1][j - 1] + array[i][j];
				} else {
					array[i][j] = Math.max(array[i - 1][j], array[i - 1][j - 1]) + array[i][j];
				}
				if (array[i][j] > sum)
					sum = array[i][j];
			}
		}
		System.out.println(sum);
		scanner.close();
	}
}