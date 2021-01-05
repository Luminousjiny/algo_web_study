package day0105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
	static int[] numbers;
	static int N, M;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		sb = new StringBuilder();
		
		combination(0, 1);
		
		System.out.println(sb.toString());
	}
	
	static void combination(int cnt, int curr) {
		if(cnt == M) { // M개 선택 끝
			for(int num : numbers)
				sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = curr; i <= N; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i); // i ~ N 까지 중 선택 (중복 선택 가능하기 때문)
		}
	}
}