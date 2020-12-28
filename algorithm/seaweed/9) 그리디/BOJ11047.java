package day1203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		int[] coins = new int[N];
		int[] cntCoins = new int[N];
		int totalCoin = 0;
		
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N - 1; i >= 0; i--) {
			cntCoins[i] = K / coins[i];
			K = K - coins[i] * cntCoins[i];
			totalCoin += cntCoins[i];
		}
		System.out.println(totalCoin);
	}

}