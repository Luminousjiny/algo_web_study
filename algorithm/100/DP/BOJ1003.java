package DP;

import java.util.Scanner;

public class BOJ1003 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] array = new int[41][2];
		array[0][0] = 1;
		array[0][1] = 0;
		array[1][0] = 0;
		array[1][1] = 1;
		
		int t = scanner.nextInt();
		for(int i = 2; i < 41; i++) {
			array[i][0] = array[i-2][0] + array[i-1][0];
			array[i][1] = array[i-2][1] + array[i-1][1];
		}
		
		for(int i = 0 ; i < t; i++) {
			int input = scanner.nextInt();
			System.out.println(array[input][0] + " " + array[input][1]);
		}
		scanner.close();
	}
}
