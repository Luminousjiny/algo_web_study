package day0105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
	static int[] numbers;
	static int N, M;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// N개 중 M개 선택
		// 중복 가능 -> 중복 순열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		
		permutation(0);
		
		System.out.println(sb.toString());
	}
	
	static void permutation(int cnt) {
		if(cnt == M) { // M개 선택 끝
			for(int num : numbers)
				sb.append(num).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			numbers[cnt] = i;
			permutation(cnt + 1);
		}
	}
}