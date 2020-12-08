import java.util.Scanner;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int[] array = new int[9];
		int i = 0;
		for (; i < 9; i++)
			array[i] = sc.nextInt();
		int max = array[0];
		int count = 0;
		for (i = 0; i < 9; i++) {
			if (max < array[i]) {
				max = array[i];
				count = i;
			}
		}
		System.out.println(max);
		System.out.println(count+1);
	}
}
