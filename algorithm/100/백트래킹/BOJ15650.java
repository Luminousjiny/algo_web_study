package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
	static int N, M;
	static boolean[] visited;
	static int[] array;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[M];
		visited = new boolean[N+1];
		permutation(1,0);
		System.out.println(sb);
	}
	static void permutation(int current, int count) {
		if(count == M) {
			for(int i = 0 ; i < M; i++) {
				sb.append(array[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = current; i <= N; i++) {
			if(visited[i] == true)
				continue;
			visited[i] = true;
			array[count] = i;
			permutation(i, count + 1);
			visited[i] = false;
		}
	}
}
