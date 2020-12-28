package day1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, M;
	static int MAX_DAY;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력부
		bfs();
		br.close();
	}

	public static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		int day = 0;
		for (int i = 0; i < M; i++) {// 처음에 1인 곳은 익은 토마토가 있는곳이겠쥬?
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					queue.offer(new Point(i, j, day));
				}
			}
		}
		while(!queue.isEmpty())//bfs를 활용합시다.
		{
			Point temp = queue.poll();//하나를 끄내서.
			day = temp.day;
			for(int i = 0; i < 4; i++) //4방향을 확인합니다.
			{
				int nextX = temp.x + dx[i];
				int nextY = temp.y + dy[i];
				
				if(0 <= nextX && 0 <= nextY && nextX < M && nextY < N)//범위 내 인가요?
				{
					if (map[nextX][nextY] == 0) {//만약 그곳에 토마토 안 익었나요??
                        map[nextX][nextY] = 1; 
                        queue.offer(new Point(nextX, nextY, day + 1));// 바꿔주고 Queue에 넣어줍시다. 대신 그떄는 날짜도 하루 늘려야합니다.
                    }
				}
			}
			if(MAX_DAY < day) // 다돌고 나왔는데 MAX_Day가 day보다 낮으면 안됩니다.
				MAX_DAY = day;
		}
		if(mapCheck()) //전체 상자를 확인을 해봤을 때 다 익었나요?
		{
			System.out.println(MAX_DAY);
		}
		else// 전체맵을 확인했는데 덜 익은 토마토가 나왔습니다.
		{
			System.out.println("-1");
		}
	}

	public static boolean mapCheck() {
		// ture = 가능, false = 불가능
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)//덜 익은 토마토가 남아있네요.
					return false;
			}
		}
		return true;
	}

	static class Point {
		int x, y, day;

		Point(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}