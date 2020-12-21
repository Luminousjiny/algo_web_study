import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 행, 열
	static int[][] map;
	static int[][][] visit; // 어떤 좌표 i,j에 벽을 안부수고 0, 부수고1 각각 거리 기록용도

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new int[N][M][2];

		for (int i = 0; i < N; i++) { // 맵 입력받기
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j] - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { // 초기에는 모든 칸까지의 거리 최대로 잡아놓고 더 작은값 나타나면 갱신해서 움직여야지~~
				for (int k = 0; k < 2; k++) {
					visit[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0, 0));
		visit[0][0][0] = 1; // 출발점에서 거리 일단 1. 여기서 +1해서 거리가 멀어짐.
		visit[0][0][1] = 1;

		while (!queue.isEmpty()) { // 방문 가능 좌표가 있다면
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int ni = now.i + di[d];
				int nj = now.j + dj[d];
				
				// 옆칸 ni, nj가 빈칸이고 기존 그칸까지의 거리보다 지금 now찍고 가는게 더 빠른 경우(내가 벽을 부수고 왔든 안부수고 왔든)
				if (check(ni, nj) && map[ni][nj]==0 && visit[ni][nj][now.wall] > visit[now.i][now.j][now.wall]+1) {
					visit[ni][nj][now.wall] = visit[now.i][now.j][now.wall]+1;
					queue.add(new Point(ni, nj, now.wall));
				}else if(check(ni, nj)&& map[ni][nj]==1 && now.wall==0) {
					// 옆칸 ni, nj가 벽일때는 현재 내가 벽을 부순적이 없는 상태여야함.
					visit[ni][nj][1] = visit[now.i][now.j][0] + 1;
					queue.add(new Point(ni, nj, 1));
				}
			}
		}

		int ans = Math.min(visit[N - 1][M - 1][0], visit[N - 1][M - 1][1]);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	// 유효조건 체크
	static boolean check(int i, int j) {
		if (i >= 0 && i < N && j >= 0 && j < M)
			return true;
		return false;
	}

	static class Point {
		int i, j, wall; // 벽을 부순 횟수 0 or 1

		public Point(int i, int j, int wall) {
			this.i = i;
			this.j = j;
			this.wall = wall;
		}
	}
}