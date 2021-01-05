package day0105;

import java.util.Scanner;

public class BOJ15649 {

	static int[] numbers;
	static boolean[] isSelected;
	static int N, M;
	static StringBuilder sb;
	public static void main(String[] args) {
		// N개 중 M개 선택 (중복 x)
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[M];
		isSelected = new boolean[N + 1];

		permutation(0);

		System.out.println(sb.toString());
	}

	static void permutation(int cnt) {
		if (cnt == M) { // M개 선택 끝
			for (int num : numbers)
				sb.append(num).append(' ');
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}