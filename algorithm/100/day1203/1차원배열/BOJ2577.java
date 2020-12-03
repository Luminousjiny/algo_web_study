import java.util.Scanner;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int Number = 0;
		Number =	A * B * C;
		
		int i = 0;
		int[] array = new int[10];
		for (; Number > 0; i++) {
			array[Number % 10]++;
			Number /= 10;
		}
		for (i = 0; i < 10; i++)
			System.out.println(array[i]);
	}
}
