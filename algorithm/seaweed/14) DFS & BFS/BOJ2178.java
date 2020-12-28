package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178 {
	static int N, M;
	static char[][] maze;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		maze = new char[N][M];
		dist = 1;
		
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			
			for(int j = 0; j < M; j++) {
				maze[i][j] = row.charAt(j);
			}
		} // 입력 끝
		bfs();
		System.out.println(dist);
	}
	
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		maze[0][0] = '0';
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s = 0; s < size; s++) {
				Point curr = queue.poll();
				if(curr.i == N-1 && curr.j == M-1)
					return;
				
				for(int d = 0; d < 4; d++) {
					int ni = curr.i + di[d];
					int nj = curr.j + dj[d];
					
					if(ni >= 0 && ni < N && nj >= 0 && nj < M && (maze[ni][nj] == '1')) {
						queue.add(new Point(ni, nj));
						maze[ni][nj] = '0';
					}
				}
			}
			dist++;
		}
	}
}