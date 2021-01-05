package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BOJ2805_timeout {
	static int K;
	static long N;
	static long MAX;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Long.parseLong(st.nextToken());
		long[] array = new long[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			array[i] = Long.parseLong(st.nextToken());
			MAX = Math.max(MAX, array[i]);
		}
		bw.append((char) (binarySearch(array)));
		bw.flush();
		bw.close();
		br.close();
	}

	private static long binarySearch(long[] array) {
		// 이분탐색
		long start = 1;
		long end = MAX;
		long mid = 0;

		while (start < end) {
			mid = (start + end) / 2;
			long sum = 0;
			for (int i = 0; i < K; i++) {
				if (array[i] > mid)
					sum += (array[i] - mid);
			}
			if (sum > N) {
				start = mid - 1;
			} else if (sum == N) {
				break;
			} else {
				end = mid + 1;
			}
		}
		return mid;
	}
}