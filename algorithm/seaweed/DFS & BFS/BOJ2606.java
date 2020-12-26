package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {

	static Queue<Integer> queue;
	static boolean[] visited; // 방문 여부 체크
	static boolean[][] network; // 인접행렬
	static int N, M;
	static int ans; // 감염된 컴퓨터 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		ans = 0;
		network = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		visited[1] = true; // 1번 컴퓨터가 시작

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			network[from][to] = true;
			network[to][from] = true;
		} // 입력 끝

		/* BFS */
		System.out.println(bfs(1));

		/* DFS */
//		dfs(1);
//		System.out.println(ans);
	}

	static int bfs(int start) {
		queue = new LinkedList<>();
		queue.offer(start);

		while(!queue.isEmpty()) {
			int curr = queue.poll();

			for(int i = 1; i <= N; ++i) {
				if(network[curr][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					++ans;
				}
			}
		}// 바이러스 전파 끝

		return ans;
	}

	static void dfs(int curr) {
		for (int i = 1; i <= N; ++i) {
			if (network[curr][i] && !visited[i]) {
				visited[i] = true;
				++ans;
				dfs(i);
			}
		}
	}
}