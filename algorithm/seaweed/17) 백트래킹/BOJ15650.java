package day0105;

import java.util.Scanner;

public class BOJ15650 {

	static int[] numbers;
	static int N, M;
	static StringBuilder sb;
	public static void main(String[] args) {
		// N개중 M개 선택
		// 고른 수열은 오름차순 -> 중복x, 뽑는 순서 상관 없음 -> 조합
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];

		combination(0, 1);

		System.out.println(sb.toString());
	}

	static void combination(int cnt, int curr) {
		if (cnt == M) { // M개 선택 끝
			for (int num : numbers)
				sb.append(num).append(' ');
			sb.append('\n');
			return;
		}

		for (int i = curr; i <= N; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1); // i+1 ~ N 사이에서 선택
		}
	}
}