package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Line implements Comparable<Line> {
	int left;
	int right;
	Line(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public int compareTo(Line o) {
		if (this.left < o.left)
			return -1;
		else if (this.left > o.left)
			return 1;
		return 0;
	}
}

public class BOJ2565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Line[] array = new Line[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			array[i] = new Line(left, right);
		}
		Arrays.sort(array);

		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			if (dp[i] == 0)
				dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (array[i].right > array[j].right) { 
					if (dp[i] < dp[j] + 1)
						dp[i] = dp[j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++)
			max = max < dp[i] ? dp[i] : max;
		System.out.println(N - max);
	}
}