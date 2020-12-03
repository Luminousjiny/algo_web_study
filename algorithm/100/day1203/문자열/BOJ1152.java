import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		int check = 1;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == ' ')
				check++;
		}
		if (S.charAt(0) == ' ')
			check--;
		if (S.charAt(S.length() - 1) == ' ')
			check--;
		System.out.println(check);
	}
}
