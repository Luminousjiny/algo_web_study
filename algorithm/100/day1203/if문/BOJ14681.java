import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int X = scanner.nextInt();
		int Y = scanner.nextInt();
		int answer=0;
		if (X < 0) {
			if (Y < 0)
				answer = 3;
			else if (Y > 0)
				answer = 2;
		} else if (0 < X) {
			if (Y < 0)
				answer = 4;
			else if (Y > 0)
				answer = 1;
		}
		System.out.println(answer);
	}
}