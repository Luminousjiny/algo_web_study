package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
	static int R = 0;
	static int G = 1;
	static int B = 2;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] list = new int[3][n+1];
		int r, g, b = 0;
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			r= Integer.parseInt(st.nextToken());
			g= Integer.parseInt(st.nextToken());
			b= Integer.parseInt(st.nextToken());
			
			list[R][i] = Math.min(list[G][i-1], list[B][i-1]) + r;	
			list[G][i] = Math.min(list[R][i-1], list[B][i-1]) + g;	
			list[B][i] = Math.min(list[R][i-1], list[G][i-1]) + b;	
		}
		System.out.println(Math.min(list[R][n], Math.min(list[G][n], list[B][n])));
	}
}
