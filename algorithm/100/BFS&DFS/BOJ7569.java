package day1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
	//쉽게 생각해보면 x축, y축, z축입니다.
	static int[] dx = { 1, -1, 0, 0, 0, 0 }; 
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int[][][] map;
	static int count = 0;

	static int N;
	static int M;
	static int L;
	static Queue<Point> tomato = new LinkedList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[L][M][N]; // 맵에 정보를 하나씩 넣어줍시다.

		for (int i = 0; i < L; i++) {
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						tomato.add(new Point(i, j, k, 0));//토마토가 있는곳이 있다면 바로 넣어버립시다.
					}
				}
			}
		}
		dfs();
	}

	public static void dfs() {
		int day = 0;
		while (!tomato.isEmpty()) {//토마토가 빌떄까지 시작합니다.
			Point temp = tomato.poll();//잠시 꺼내서
			day = temp.day;//날짜를 저장합니다.
			for (int i = 0; i < 6; i++) {// 6방향을 다 확인해봅시다.
				int nextX = temp.x + dx[i];
				int nextY = temp.y + dy[i];
				int nextZ = temp.z + dz[i];

				if (0 <= nextX && nextX < L && 0 <= nextY && nextY < M && 0 <= nextZ && nextZ < N) {// 범위내인가요?
					if (map[nextX][nextY][nextZ] == 0) {//만약 덜 익은 토마토가 발견되면
						map[nextX][nextY][nextZ] = 1;// 익힌 후
						tomato.add(new Point(nextX, nextY, nextZ, day + 1));//다음 토마토로 넣는데, 날짜는 하루 늘려줍시다.
					}
				}
			}
		}

		if (mapCheck())//다 돌고 나왔는데 토마토가 다 익었다.
			System.out.println(day);
		else// 아직 덜익은 토마토가 있다.
			System.out.println("-1");
	}

	public static boolean mapCheck() {
		// ture = 가능, false = 불가능
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {//덜 익은 토마토가 남아있네요.
					if (map[i][j][k] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

class Point {
	int x;
	int y;
	int z;
	int day;

	Point(int x, int y, int z, int day) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.day = day;
	}
}