package day1222;

import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ1012 {
	static int R;
	static int C;
	static int worm;
	static boolean[][] farm;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 지렁이 인접 배추도 ㅇㅋ(상하좌우)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			String[] line = br.readLine().split(" ");
			
			C = Integer.parseInt(line[0]);
			R = Integer.parseInt(line[1]);
			
			worm = 0;
			farm = new boolean[R][C];
			
			int N = Integer.parseInt(line[2]);
			
			for(int i = 0; i < N; i++) {
				String[] pos = br.readLine().split(" ");
				
				int c = Integer.parseInt(pos[0]);
				int r = Integer.parseInt(pos[1]);
				
				farm[r][c] = true;
			}// 배추심기 끝
			
			
			for(int r = 0; r < R; r++) {
				for(int c= 0; c < C; c++) {
					if(farm[r][c]) {
						bfs(new Point(r, c));
						worm++;
					}
				}
			}// 벌레 뿌리기 끝
			System.out.println(worm);
		}
	}
	
	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		farm[start.r][start.c] = false;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int ni = curr.r + di[d];
				int nj = curr.c + dj[d];
				
				if(ni >= 0 && ni < R && nj >= 0 && nj < C && farm[ni][nj]) {
					queue.offer(new Point(ni, nj));
					farm[ni][nj] = false;
				}
			}
		}
	}
	
	static class Point {
		int r, c;
		
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

}