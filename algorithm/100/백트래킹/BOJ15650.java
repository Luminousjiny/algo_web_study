package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제의 조건=
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
-> 조합 
*/

public class BOJ15650 {
	static int N, M;
	static int[] array;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[M];
		combination(1,0);
		System.out.println(sb);
	}
	static void combination(int current, int count) {// 조합
		if(count == M) {// M개만큼 선택을 했다면
			for(int i = 0 ; i < M; i++) {
				sb.append(array[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = current; i <= N; i++) { // 하나씩 선택을 합니다.
			array[count] = i;
			combination(i+1, count + 1);
		}
	}
}
