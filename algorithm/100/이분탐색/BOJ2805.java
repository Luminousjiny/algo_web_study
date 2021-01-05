package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BOJ2805 {
	static int K;
	static int N;
	static int MAX;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[] array = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			MAX = Math.max(MAX, array[i]);
		}
		System.out.println(binarySearch(array));
		br.close();
	}

	private static int binarySearch(int[] array) {
		// 이분탐색
		int start = 1;
		int end = MAX;
		int mid = 0;
		int h = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			long sum = 0;
			for (int i = 0; i < K; i++) {
				if (array[i] >= mid)
					sum += (array[i] - mid);
			}
			if (sum >= N) {
				start = mid + 1;
				if(h < mid)
					h = mid;
			}else {
				end = mid - 1;
			}
		}
		return h;
	}
}