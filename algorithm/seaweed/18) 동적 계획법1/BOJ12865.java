package day0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
	/**
	 * 1 <= N <= 100
	 * 1 <= K <= 100,000
	 * 1 <= W <= 100,000
	 * 0 <= V <= 1,000
	 */
	static int N, K;
	static int[][] products;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		products = new int[N + 1][2]; // 무게, 가치
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			products[i][0] = Integer.parseInt(st.nextToken()); // 무게
			products[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}
		
		dp = new int[N + 1][K + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= K; j++) {
				if(products[i][0] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-products[i][0]] + products[i][1]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		br.close();
	}

}