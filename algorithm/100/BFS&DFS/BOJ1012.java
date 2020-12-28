package day1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1012 {
	static int m, n;
	static int[][] map;
	static boolean[][] visited;
	static int checkArea;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		while(!((testCase--) == 0)) {
			String temp[] = br.readLine().split(" ");
			m = Integer.parseInt(temp[0]);
			n = Integer.parseInt(temp[1]);
			int k = Integer.parseInt(temp[2]);
			
			map = new int[m][n];
			visited = new boolean[m][n];
			for(int i = 0 ; i < k; i++) {
				temp = br.readLine().split(" ");
				map[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = 1;
			}
			int whiteWorm = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						checkArea = 0;
						dfs(i, j);
						if (checkArea != 0)
							whiteWorm++;
					}
				}
			}
			System.out.println(whiteWorm);
		}
	}
	public static void dfs(int x, int y) {
		if (visited[x][y] == true) {
			return;
		}
		visited[x][y] = true;
		checkArea++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < m && ny < n && 0 <= ny) {
				if (map[nx][ny] == 1)
					dfs(nx, ny);
			}
		}
	}
}
