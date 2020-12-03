import java.util.Scanner;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int Number = 0;
		int count = 0;
		int[] array = new int[10];
		int[] array2 = new int[42];
		int i = 0;
		for (; i < 10; i++) {
			Number = sc.nextInt();
			array[i] = Number % 42;
			array2[array[i]]++;
		}
		for (i = 0; i < 42; i++) {
			if (array2[i] != 0)
				count++;
		}
		System.out.println(count);

	}
}
