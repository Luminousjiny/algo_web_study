import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int sec;
	static boolean[] visit = new boolean[1000001];
	static StringTokenizer st;
	static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		queue = new LinkedList<Integer>();
		if (N == K) {
			sec = 0;
		} else {
			queue.offer(N);
			sec = 0; // 시간
			while (!queue.isEmpty()) {
				int s = queue.size();
				while (s > 0) {
					int x = queue.poll(); // 큐에서 꺼내서
					if (x == K) { // 끝내주기
						queue.clear();
						break;
					}
					int[] nx = new int[3];
					nx[0] = x * 2;
					nx[1] = x + 1;
					nx[2] = x - 1;

					// 큐에 넣기 전 범위 안에 있고 이미 방문했는지 체크
					for (int j = 0; j < 3; j++) {
						if (nx[j] >= 0 && nx[j] < 1000001) {
							if (!visit[nx[j]]) {
								if (nx[j] == K) { // 끝내주기
									queue.clear();
									s = 0;
									break;
								}
								visit[nx[j]] = true;
								queue.offer(nx[j]);
							}
						}
					}
					s--;
				}
				sec++;
			}
		}
		System.out.println(sec);
	}
}