import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int N = 0;
		double avr = 0;

		for (int i = 0; i < C; i++) {
			N = sc.nextInt();
			int[] array = new int[N];
			int sum = 0;
			int num = 0;
			for (int j = 0; j < N; j++) {
				array[j] = sc.nextInt();
				sum += array[j];
			}
			avr = (double) sum / N;

			for (int j = 0; j < N; j++) {
				if (array[j] > avr)
					num++;

			}
			System.out.printf("%.3f", 100.0 * num / N);
			System.out.println("%");
		}

	}
}
