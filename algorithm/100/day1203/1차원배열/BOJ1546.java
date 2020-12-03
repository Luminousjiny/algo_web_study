import java.util.Scanner;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] array = new int[N];
		int max = 0;
		double sum = 0;
		double avr = 0;
		int i = 0;
		for (; i < N; i++) {
			array[i] = sc.nextInt();
			if (max < array[i])
				max = array[i];
			sum += array[i];
		}
		avr = (sum / max * 100) / N;
		System.out.printf("%.2f", avr);

	}
}
