package day0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {
	/**
	 * 1 <= 삼각형 크기(N) <= 500
	 * 0 <= 삼각형 내부 수 <= 9999
	 */
	static int N, ans;
	static int[][] dp;
	static int[] dj = {-1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		ans = 0;
		dp = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < i + 1; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 끝
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i + 1; j++) {
				int value = dp[i][j];
				
				for(int d = 0; d < 2; d++) {
					int ni = i - 1;
					int nj = j + dj[d];
					
					if(nj >= 0 && nj < N) {
						dp[i][j] = Math.max(dp[i][j], value + dp[ni][nj]);
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[N-1][i]);
		}
		
		System.out.println(ans);
	}

}