import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//DFS와 BFS
public class Main {
	static int N, M, V; //정점개수, 간선개수, 시작 정점
	static boolean[][] map;
	static boolean[] dfs_visit; //방문체크
	static boolean[] bfs_visit;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		dfs_visit = new boolean[N+1];
		bfs_visit = new boolean[N+1];
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = map[to][from] = true;
		}
	
		//조건: 방문할 수 있는 정점이 여러개면 가장 작은 번호 먼저 방문
		//dfs 시작
		dfs(V);
		System.out.println();
		bfs(V);
	}
	
	static void dfs(int current) {
		dfs_visit[current] = true; //방문표시
		System.out.print(current+" ");
		
		for(int i=1; i<=N; i++) {
			if(map[current][i] && !dfs_visit[i]) { //간선이 있고 아직 방문 안했다면
				dfs(i);
			}
		}
	}
	
	static void bfs(int current) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(current);
		bfs_visit[current] = true;
		
		while(!queue.isEmpty()) { //큐가 빌때까지
			 current = queue.poll();
			 System.out.print(current+" ");
			 for(int i=1; i<=N; i++) {
				 if(map[current][i] && !bfs_visit[i]) {
					 queue.offer(i);
					 bfs_visit[i] = true;
				 }
			 }
		}
	}
}