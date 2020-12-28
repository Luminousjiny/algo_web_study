package day1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1260 {
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int V = Integer.parseInt(temp[2]);
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		while (0 < M) {
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			map[x][y] = map[y][x] = 1;
			M--;
		}
		dfs(V,N);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V,N);
	}
	private static void bfs(int k, int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(k);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			visited[temp] = true;
			System.out.print(temp + " ");
			for(int i = 1 ; i <= n; i++) {
				if(map[temp][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i]=true;
				}
			}
		}
	}
	private static void dfs(int k , int n) {
		if(visited[k])
			return;
		visited[k] = true;
		System.out.print(k+" ");
		for(int i = 1; i <= n; i++) {
			if(map[k][i]==1) 
				dfs(i,n);
		}
	}
}
