import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//ATM
public class Main {
	static int N;
	static int[] map;
	static int[] result; //누적된 합
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		map = new int[N];
		result = new int[N];
		for (int i = 0; i < N; i++)
			map[i] = Integer.parseInt(st.nextToken());

		// 오름차순
		Arrays.sort(map);
		int sum = 0;
		int Ans = 0;
		for (int i = 0; i < N; i++) {
			sum += map[i];
			result[i] = sum;
			Ans += result[i];
		}
		
		System.out.println(Ans);
	}
}