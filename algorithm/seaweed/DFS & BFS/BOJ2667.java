package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class BOJ2667 {
	//				{상 하 좌 우}
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int N;
	static boolean[][] map;
	static int[] apartments;
	static int top;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		apartments = new int[N * N];
		top = 0;
		
		for(int r = 0; r < N; r++) {
			String line= br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = (line.charAt(c) == '0') ? false : true;
			}
		} // 입력 끝
		
		for(int r = 0; r < N; r++) {
			for(int c= 0; c < N; c++) {
				if(map[r][c])
					bfs(new Point(r, c));
			}
		}
		System.out.println(top);
		
		int[] danG = new int[top];
		for(int i = 0; i < top; i++)
			danG[i] = apartments[i];
		
		Arrays.sort(danG);
		for(int num : danG)
			System.out.println(num);
		
	}
	
	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		map[start.r][start.c] = false;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int ni = curr.r + di[d];
				int nj = curr.c + dj[d];
				
				if(ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj]) {
					queue.offer(new Point(ni, nj));
					map[ni][nj] = false;
					cnt++;
				}
			}
		}// 한 단지 개수 세기 끝
		
		apartments[top++] = cnt;
	}
	
	
	static class Point {
		int r, c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}