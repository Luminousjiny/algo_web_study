import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int size;
	static List<cctvClass> cctvs = new ArrayList<>();
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= map[i][j] && map[i][j] <= 5)
					cctvs.add(new cctvClass(i, j, map[i][j]));

			}
		}
		size = cctvs.size();// 사이즈
		dfs(0);
		System.out.println(answer);
	}

	static void dfs(int count) {
		if (count == size) {
			int[][] tempMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				tempMap[i] = map[i].clone();
			}
			tempMap = setArea(tempMap);
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tempMap[i][j] == 0)
						sum++;
				}
			}
			answer = Math.min(sum, answer);
		} else {
			cctvClass cctv;
			cctv = cctvs.get(count);
			int[] temp = cctv.dir;
			if (cctv.kinds == 1 || cctv.kinds == 3 || cctv.kinds == 4) {
				for (int dir = 0; dir < 4; dir++) {
					for (int i = 0; i < cctv.dir.length; i++) {
						cctv.dir[i] += dir;
						cctv.dir[i] = cctv.dir[i] % 4;
					}
					dfs(count + 1);
					cctv.dir = temp;
				}
			} else if (cctv.kinds == 2) {
				for (int dir = 0; dir < 2; dir++) {
					for (int i = 0; i < cctv.dir.length; i++) {
						cctv.dir[i] += dir;
						cctv.dir[i] = cctv.dir[i] % 4;
					}
					dfs(count + 1);
					cctv.dir = temp;
				}
			} else if (cctv.kinds == 5) {
				dfs(count + 1);
			}
		}
	}

	static int[][] setArea(int[][] tempMap) {
		cctvClass cctv;
		for (int i = 0; i < size; i++) {
			cctv = cctvs.get(i);
			int dir;
			for (int j = 0; j < cctv.dir.length; j++) {
				dir = cctv.dir[j];
				int nextX = cctv.x;
				int nextY = cctv.y;
				while (true) {
					nextX += dx[dir];
					nextY += dy[dir];
					if (isIn(nextX, nextY)) {
						if (tempMap[nextX][nextY] == 0) {
							tempMap[nextX][nextY] = 7;
						} else if (map[nextX][nextY] == 6)
							break;
					} else {
						break;
					}
				}
			}
		}
		return tempMap;
	}

	static boolean isIn(int x, int y) {
		if (x < 0 || N <= x || y < 0 || M <= y) {
			return false;
		}
		return true;
	}

	static class cctvClass {
		int x;
		int y;
		int kinds;
		int[] dir;

		cctvClass(int x, int y, int kinds) {
			this.x = x;
			this.y = y;
			this.kinds = kinds;

			if (kinds == 1) { // 한방향
				this.dir = new int[1];
				dir[0] = 0;
			} else if (kinds == 2) {// 2방향 - 반대방향
				this.dir = new int[2];
				dir[0] = 0;
				dir[1] = 2;
			} else if (kinds == 3) {// 2방향 - 90도
				this.dir = new int[2];
				dir[0] = 0;
				dir[1] = 1;
			} else if (kinds == 4) {// 3방향
				this.dir = new int[3];
				dir[0] = 0;
				dir[1] = 1;
				dir[2] = 2;
			} else if (kinds == 5) {//모든방향
				this.dir = new int[4];
				dir[0] = 0;
				dir[1] = 1;
				dir[2] = 2;
				dir[3] = 3;
			}
		}
	}
}
