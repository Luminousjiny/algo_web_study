package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1300 {
	static long N, K, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		K = Long.parseLong(br.readLine());
		long left = 1;
		long right = K;
		System.out.println(binarySearch(left, right));
	}

	static long binarySearch(long left, long right) {
		int count = 0;
		long mid = (left + right) / 2;
		if (left > right)
			return answer;
		for (int i = 1; i <= N; i++) {
			count += Math.min(mid / i, N);
		}
		if (K <= count) {
			answer = mid;
			return binarySearch(left, mid - 1);
		} else {
			return binarySearch(mid + 1, right);
		}
	}
}