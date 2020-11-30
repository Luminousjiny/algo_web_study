import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//1546 평균
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			int score = sc.nextInt();
			if(score > M) M = score;
			sum += score;
		}
		
		System.out.printf("%.2f", (double)sum / (double)M*100 / N);

	}
}
