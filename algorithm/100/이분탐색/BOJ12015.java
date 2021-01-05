package 이분탐색;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12015 { 
	static int N, index, ans;
	static int[] array, list;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		array = new int[N];
		list = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		list[0] = array[0];
		index = 0;
		for (int i = 1; i < N; i++) {//정렬하면서 lowerbound 구하기
			if (list[index] < array[i]) {
				list[++index] = array[i];
			} else {
				int lower = lowerBound(array[i]);
				list[lower] = array[i];
			}
		}
		ans = index + 1;
		System.out.println(ans);
	}

	private static int lowerBound(int k) {
		int left = 0;
		int right = index + 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (list[mid] < k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}
}