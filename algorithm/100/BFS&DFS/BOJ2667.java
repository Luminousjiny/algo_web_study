package day1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ2667 {
	static int[][] map;
	static boolean[][] visited;
	static int houseCount;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int apartmentFlex = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					houseCount = 0;
					dfs(i, j);
					if (houseCount != 0) {
						apartmentFlex++;
						pq.add(houseCount);
					}
				}
			}
		}
		System.out.println(apartmentFlex);
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	static void dfs(int x, int y) {
		if (visited[x][y] == true)
			return;

		visited[x][y] = true;
		houseCount++;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
				if(map[nextX][nextY]==1) {
					dfs(nextX,nextY);
				}
			}
		}
	}
}
