package day1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int answer;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs();
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	public static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		visited[0][0][0] = true;
		queue.add(new Point(0, 0, 1, 0));
		while (!queue.isEmpty()) {
			Point temp = queue.poll();

			if (temp.x == N - 1 && temp.y == M - 1) {
				answer = Math.min(temp.distance, answer);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nextX = temp.x + dx[i];
				int nextY = temp.y + dy[i];
				if (0 <= nextX && 0 <= nextY && nextX < N && nextY < M)
				{
					if(temp.drill == 1)
					{
						if(map[nextX][nextY] == 0 && !visited[nextX][nextY][temp.drill])
						{
							visited[nextX][nextY][temp.drill] = true;
							queue.add(new Point(nextX,nextY,temp.distance+1, temp.drill));
						}
					}
					else {
						if(map[nextX][nextY]==1 && !visited[nextX][nextY][temp.drill]) {
								visited[nextX][nextY][temp.drill]=true; 
								queue.add(new Point(nextX,nextY,temp.distance+1, temp.drill+1));
						}
						else if(map[nextX][nextY]==0 &&!visited[nextX][nextY][temp.drill]) {
								visited[nextX][nextY][temp.drill]=true;
								queue.add(new Point(nextX,nextY,temp.distance+1, temp.drill));
						}
					}
				}
			}

		}
	}

	static class Point {
		int x;
		int y;
		int distance;
		int drill;

		Point(int x, int y, int distance, int drill) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.drill = drill;
		}
	}
}
