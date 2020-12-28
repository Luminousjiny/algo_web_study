package day1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1697 {
	static int N, K, minTime; // 수빈, 동생 위치, 찾는데 걸리는 최소 시간
	static boolean[] visited;
	static final int MAX_SIZE = 100001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		visited = new boolean[MAX_SIZE];

		bfs(N);

		System.out.println(minTime);
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean stop = false;

		queue.add(start);
		visited[start] = true;
		int cnt = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int curr = queue.poll();

				if (curr == K) {
					minTime = cnt;
					stop = true;
					break;
				}

				if ((curr * 2) < MAX_SIZE && curr != 0 && !visited[curr * 2]) {
					queue.add(curr * 2);
					visited[curr * 2] = true;
				}
				if (curr > 0 && !visited[curr - 1]) {
					queue.add(curr - 1);
					visited[curr - 1] = true;
				}
				if (curr < K && !visited[curr + 1]) {
					queue.add(curr + 1);
					visited[curr + 1] = true;
				}
			} // 1초 지남
			cnt++;
			if (stop)
				break;
		}
	}
}