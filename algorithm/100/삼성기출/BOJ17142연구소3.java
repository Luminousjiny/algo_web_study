import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visit;
	static boolean[] check;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M, answer = Integer.MAX_VALUE;
	static int emptyCount = 0;
	static List<Virus> virusList = new ArrayList<Virus>();
	static List<Virus> selectedList = new ArrayList<Virus>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					emptyCount++;
				}
				if (map[i][j] == 2) {
					virusList.add(new Virus(i, j));
				}
			}
		}
		if (emptyCount == 0)
			System.out.println(0);
		else {
			check = new boolean[virusList.size()];
			select(0);
			System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		}
	}

	private static void select(int index) {
		if (selectedList.size() == M) {
			spread();
			return;
		}
		if (index == virusList.size()) {
			return;
		}
		for (int i = index; i < virusList.size(); i++) {
			if (!check[i]) {
				check[i] = true;
				selectedList.add(new Virus(virusList.get(i).x, virusList.get(i).y));
				select(i + 1);
				selectedList.remove(selectedList.size() - 1);
				check[i] = false;
			}
		}

	}

	private static void spread() {
		visit = new boolean[N][N];
		Queue<Virus> queue = new LinkedList<Virus>();
		for (Virus temp : selectedList)
			queue.offer(temp);
		int count = 0;
		int time = 1;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			while (queueSize-- > 0) {
				Virus temp = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = temp.x + dx[i];
					int nextY = temp.y + dy[i];
					if (isIn(nextX, nextY) && !visit[nextX][nextY] && map[nextX][nextY] != 1) {
						visit[nextX][nextY] = true;
						if (map[nextX][nextY] == 0)
							count++;
						if (count == emptyCount) {
							if (answer > time)
								answer = time;
							return;
						}
						queue.offer(new Virus(nextX, nextY));
					}
				}
			}
			time++;
		}
	}

	private static boolean isIn(int nextX, int nextY) {
		if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
			return false;
		else
			return true;
	}

	static class Virus {
		int x;
		int y;

		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}