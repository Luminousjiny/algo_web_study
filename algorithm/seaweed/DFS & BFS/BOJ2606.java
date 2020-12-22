package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2606 {
	static Queue<Integer> queue;
	static boolean[] visited;
	static boolean[][] network;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		network = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			String[] line = br.readLine().split(" ");
			int from = Integer.parseInt(line[0]);
			int to = Integer.parseInt(line[1]);
			
			network[from][to] = true;
			network[to][from] = true;
		} // 입력 끝
		
		int ans = bfs(1);
		System.out.println(ans);
	}
	static int bfs(int start) {
		int ans = 0;
		queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int i = 1; i <= N; i++) {
				if(network[curr][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					ans++;
				}
			}
		}// 바이러스 전파 끝
		
		return ans;
	}
}