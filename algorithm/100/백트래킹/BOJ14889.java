package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
	static int N, answer;
	static int[][] S;
	static boolean isStartTeam[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isStartTeam = new boolean[N];
		answer = Integer.MAX_VALUE;
		permutation(0, 0);
		System.out.println(answer);
	}

	private static void permutation(int index, int count) {
		if (index == N)
			return;
		if (answer == 0)
			return;
		if (count == N / 2) {
			int startTeam = 0;
			int linkTeam = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (isStartTeam[i] && isStartTeam[j])
						startTeam += S[i][j];
					if (!isStartTeam[i] && !isStartTeam[j])
						linkTeam += S[i][j];
				}
			}
			answer = Math.min(answer, Math.abs(startTeam - linkTeam));
			return;
		}
		isStartTeam[index] = true;
		permutation(index + 1, count + 1);
		isStartTeam[index] = false;
		permutation(index + 1, count);
	}
}
