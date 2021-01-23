package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
	public static int N;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			int[] column = new int[N+1];
			column[1] = i;
			DFS(column, 1);
		}
		System.out.println(count);
	}
	public static void DFS(int[] column, int row) {
		if(row ==N) {
			count++;
		}
		else {
			for(int i = 1; i <= N; i++) {
				column[row+1] = i;
				if(possibleChecking(column, row + 1)) {
					DFS(column, row +1);
				}
			}
		}
	}
	public static boolean possibleChecking(int[] column, int row) {
		for(int i = 1; i < row; i++) {
			if(column[i] == column[row]) {
				return false;
			}
			if(Math.abs(i- row) == Math.abs(column[i] - column[row]))
				return false;
		}
		return true;
	}
}
