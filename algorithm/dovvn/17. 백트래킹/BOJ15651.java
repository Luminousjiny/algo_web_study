import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//N과 M(3) - 중복순열
public class Main {

	static int N, M;
	static int[] card; // 카드저장배열
	static int[] select; // 완성 카드
	static StringTokenizer st;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		card = new int[N + 1];
		select = new int[M];

		for (int i = 1; i <= N; i++)
			card[i] = i;
		com(0);
		bw.flush();
		bw.close();
	}

	static void com(int cnt) throws IOException {
		if (cnt == M) {
			for (int i = 0; i < M; i++)
				bw.write(select[i] + " ");
			bw.newLine();
			return;
		}

		for (int idx = 1; idx <= N; idx++) { // 카드 N장
			select[cnt] = card[idx];
			com(cnt + 1);
		}
	}
}