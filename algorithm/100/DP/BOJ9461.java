package DP;

import java.util.Scanner;

public class BOJ9461 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long[] array = new long[101];
		array[1] = 1;
		array[2] = 1;
		array[3] = 1;
		
		int T = scanner.nextInt();
		for(int i = 0; i < T; i++) {
			int N = scanner.nextInt();
			for(int j = 3; j <= N; j++) {
				array[j] = array[j-2] + array[j-3];
			}
			System.out.println(array[N]);
		}
		scanner.close();
	}
}
