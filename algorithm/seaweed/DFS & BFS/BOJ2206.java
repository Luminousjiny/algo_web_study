package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2206 {
	static int N, M;
	static boolean[][] map;
	static int[][][] dist;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new boolean[N][M];
		dist = new int[N][M][2];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (row.charAt(j) == '1') ? true : false;
				dist[i][j][0] = 1000 * 1000;
				dist[i][j][1] = 1000 * 1000;
			}
		} // 입력 끝
		bfs();
		int minDist = Math.min(dist[N-1][M-1][0], dist[N-1][M-1][1]);
		System.out.println((minDist == (1000 * 1000)) ? -1 : minDist);
	}

	static class Point {
		int i, j;
		boolean didBreak;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
			this.didBreak = false;
		}

		Point(int i, int j, boolean didBreak) {
			this.i = i;
			this.j = j;
			this.didBreak = didBreak;
		}
	}

	public static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0, false));
		dist[0][0][0] = 1;

		while (!queue.isEmpty()) {
			Point curr = queue.poll();

			if (curr.i == N - 1 && curr.j == M - 1)
				break;

			for (int d = 0; d < 4; d++) {
				int ni = curr.i + di[d];
				int nj = curr.j + dj[d];
				
				if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
					if(curr.didBreak) { // 벽 부순적 있는 경우
						// 현재 경로가 가장 짧고 벽 아닌 경우
						if((dist[ni][nj][1] > dist[curr.i][curr.j][1] + 1) && !map[ni][nj]) {
							queue.add(new Point(ni, nj, curr.didBreak));
							dist[ni][nj][1] = dist[curr.i][curr.j][1] + 1;
						}
					} else { // 아직 벽 안부숨
						// 벽 안부순 애들이 갔던 경로 중 가장 짧은 경로일 때만 확인
						if((dist[ni][nj][0] > dist[curr.i][curr.j][0] + 1)) {
							if(map[ni][nj]) {
								queue.add(new Point(ni, nj, true));
								dist[ni][nj][1] = dist[curr.i][curr.j][0] + 1;
								dist[ni][nj][0] = dist[curr.i][curr.j][0] + 1;
							} else {
								queue.add(new Point(ni, nj, curr.didBreak));
								dist[ni][nj][0] = dist[curr.i][curr.j][0] + 1;
							}
						}
					}

				}
			}
		}
	}
}