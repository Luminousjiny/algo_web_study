import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//단지번호붙이기
public class Main {

	public static int N;
	public static int[][] map;
	public static int[][] visited; // 방문
	static StringTokenizer st;
	public static Queue<Home> queue;
	public static int[] di = { -1, 1, 0, 0 }; // 상,하,좌,우
	public static int[] dj = { 0, 0, -1, 1 };
	public static int[] homeCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		homeCnt = new int[N*N];
		queue = new LinkedList<Home>();
		int count = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					queue.offer(new Home(i, j));
					visited[i][j] = count;
					homeCnt[count]++;

					while (!queue.isEmpty()) {
						Home current = queue.poll();
		 				for (int dir = 0; dir < di.length; dir++) {
							int nx = current.i + di[dir];
							int ny = current.j + dj[dir];

							if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
								if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
									visited[nx][ny] = count;
									homeCnt[count]++;
									queue.offer(new Home(nx, ny));
								}
							}
						}
					}
					count++;
				}
			}
		}
		
		System.out.println(count-1); //단지수
		Arrays.sort(homeCnt);
		//집 수 카운팅
		for(int i=0; i<homeCnt.length; i++) {
			if(homeCnt[i] != 0) System.out.println(homeCnt[i]);
		}

	}

	static class Home {
		int i, j;

		public Home(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}