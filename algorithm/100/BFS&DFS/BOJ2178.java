package day1228;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
	static int N, M;
	static int Map[][];
	static boolean visited[][];
	static int[] nx = { 1, 0, -1, 0 };
	static int[] ny = { 0, 1, 0, -1 };
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		Map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = scanner.next();
			for (int j = 0; j < M; j++) {
				Map[i][j] = str.charAt(j) - '0';
				visited[i][j] = false;
			}
		}
		visited[0][0] = true;
		dfs(0, 0);
		System.out.println(Map[N - 1][M - 1]);
		scanner.close();
	}

	public static void dfs(int x, int y) {
		Queue<point> queue = new LinkedList<point>();
		point temp = new point(x, y);
		queue.add(temp);
		while (!queue.isEmpty()) {
			point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = p.x + nx[i];
				int nextY = p.y + ny[i];
				if (nextX < 0 || nextY < 0 || N <= nextX || M <= nextY)
					continue;
				if (visited[nextX][nextY] == true || Map[nextX][nextY] == 0)
					continue;
				visited[nextX][nextY] = true;
				queue.add(new point(nextX, nextY));
				Map[nextX][nextY] = Map[p.x][p.y] + 1;
			}
		}
	}
	static class point {
		int x;
		int y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
