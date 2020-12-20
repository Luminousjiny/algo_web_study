import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//평균은 넘겠지
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<C; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int sum = 0;
			int[] scores = new int[N];
			for(int i=0; i<N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
				sum += scores[i];
			}
			double avg = sum / N;
			
			int count = 0; //평균넘는애들수
			for(int score : scores) {
				if(score > avg) count++;
			}
			float countAvg = (float) count / N * 100; //평균넘는애들비율
			System.out.println(String.format("%.3f", countAvg)+"%");
		}
	}
}