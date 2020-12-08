import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int R = 0;
		String S = " ";
		while (T != 0) {
			T--;
			R = sc.nextInt();
			S = sc.next();
			for (int i = 0; i < S.length(); i++) {
				for (int j = 0; j < R; j++)
					System.out.print(S.charAt(i));
			}
			System.out.println();
		}
		sc.close();
	}
}