import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N과 M (2) nCm 중복X 순열
public class Main {

	static int N, M;
	static int[] card; // 카드저장배열
	static int[] select; //완성 카드
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		card = new int[N+1];
		select = new int[M];
		
		for(int i=1; i<=N; i++) card[i] = i;
		com(0, 1);
	}

	static void com(int cnt, int cur) {
		if (cnt == M) {
			for (int i = 0; i < M; i++)
				System.out.print(select[i] + " ");
			System.out.println();
			return;
		}

		for (int idx = cur; idx <= N; idx++) { // 카드 N장
			select[cnt] = card[idx];
			com(cnt+1, idx+1);
		}
	}
}