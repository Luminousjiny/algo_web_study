import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class MyComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			if((o1[1]-o2[1])==0)
				return o1[0]-o2[0];
			else
				return o1[1]-o2[1];
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] array = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array, new MyComparator());
		int time = 0;// 몇번째 회의인가?
		int answer = 1; // 첫타임은 무조건 처음꺼.
		for (int i = 1; i < N; i++) {
			if (array[i][0] < array[time][1])
				continue;
			answer++;
			time = i;
		}
		System.out.println(answer);

	}
}