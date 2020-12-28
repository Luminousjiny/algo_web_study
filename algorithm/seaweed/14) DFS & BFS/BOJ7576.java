package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7576 {
	//				{상, 하, 좌, 우}
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static int readyTomatoNum;
	static int N;
	static int M;
	static Queue<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// 인접 토마토 : 상하좌우 토마토
		// 혼자 익는 토마토는 없다
		// 며칠 뒤 다 익는지? 최소 일수
		// INPUT : 상자 사이즈, 익토, 안익토
		// 비어있는 칸도 있다.
		// N : row, M : col , 2~1000사이
		// 1: 익토, 0 : 안익토, -1 : 없토
		// 다 못익는다 : -1, 시작부터 다 익었다 : 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		M = Integer.parseInt(NM[0]);
		N = Integer.parseInt(NM[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		readyTomatoNum = 0;
		
		for(int r = 0; r < N; r++) {
			String[] row = br.readLine().split(" ");
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(row[c]);
				
				if(map[r][c] == 0)
					readyTomatoNum++; // 안익은 토마토 개수
				if(map[r][c] == 1) { // 처음부터 익은 토마토 위치 저장
					queue.offer(new Point(r, c));
					visited[r][c] = true;
				}
			}
		} // 입력 끝

		int ans = bfs();
		
		System.out.println(ans);
		
	}
	static int bfs() {
		int ans = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			boolean hasNext = false;
			
			for(int t = 0; t < size; t++) {
				Point curr = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int nexti = curr.i + di[d];
					int nextj = curr.j + dj[d];
					
					// 해당 위치가 박스 내부고 방문한 적 없고 안익은 토마토가 있는 경우
					if(nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj] && (map[nexti][nextj] == 0)) {
						visited[nexti][nextj] = true;
						map[nexti][nextj] = 1;
						queue.offer(new Point(nexti, nextj));
						readyTomatoNum--;
						hasNext = true;
					}
				}
			} // 하루치 숙성 끝
			if(hasNext)
				ans++;
		}
		
		return (readyTomatoNum == 0) ? ans : -1;
	}
	static class Point {
		int i, j;
		
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}