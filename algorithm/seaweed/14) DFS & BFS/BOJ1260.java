package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


// 우선순위큐를 이용한 인접리스트를 이용해 구현
public class BOJ1260 {
	static int N, M, V;
	static boolean[] visited;
	static PriorityQueue<Integer>[] graphDFS; // 우선순위큐에서 데이터를 뽑아서 검사하므로 DFS, BFS용 큐가 각각 필요하다
	static PriorityQueue<Integer>[] graphBFS;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		V = Integer.parseInt(input[2]);
		graphDFS = new PriorityQueue[N + 1];
		graphBFS = new PriorityQueue[N + 1];
		visited = new boolean[N + 1];
		sb = new StringBuilder();

		for(int i = 1; i <= N; i++) {
			graphDFS[i] = new PriorityQueue<>();
			graphBFS[i] = new PriorityQueue<>();
		}
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);

			graphDFS[from].add(to);
			graphDFS[to].add(from);
			graphBFS[from].add(to);
			graphBFS[to].add(from);

		} // 입력 끝
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(V);
		System.out.println(sb.toString());
	}

	static void dfs(int vertex) {
		visited[vertex] = true;
		sb.append(vertex + " ");

		while (!graphDFS[vertex].isEmpty()) {
			int next = graphDFS[vertex].poll();

			if (!visited[next])
				dfs(next);
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		sb.append(start + " ");

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			while (!graphBFS[curr].isEmpty()) { // 현재 정점에 연결된 정점들 확인
				int next = graphBFS[curr].poll();

				if (!visited[next]) { // 방문하지 않은 정점인 경우 큐에 넣음
					queue.add(next);
					visited[next] = true;
					sb.append(next + " ");
				}
			}
		}
	}
}