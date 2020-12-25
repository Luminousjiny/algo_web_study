import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Boolean[][] map;
	static Boolean[] visit;
	static int cnt;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

		map = new Boolean[N + 1][N + 1];
		visit = new Boolean[N+1];
		cnt = 0;
		
		//초기화
		for(int i=1; i<=N; i++) {
			visit[i] = false;
			for(int j=1; j<=N; j++) {
				map[i][j] = false;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = true; // 연결 표시
			map[end][start] = true;
		}

		// 1번 컴퓨터가 바이러스에 걸림
		dfs(1);
		for(int i=2; i<=N; i++) 
			if(visit[i]) cnt++;
		System.out.println(cnt);
	}

	static void dfs(int x) {
		visit[x] = true;
		for (int j = 1; j <= N; j++) { // x와 연결된 애들 찾기
			if (map[x][j] == true && !visit[j]) {
				map[x][j] = false;
				map[j][x] = false;
				dfs(j);
			}
		}
	}
}