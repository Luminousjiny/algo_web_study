import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		String array[] = new String[testcase];
		int i = 0;
		int j = 0;
		int score = 0;
		int total = 0;
		String test="";
		for (; i < testcase; i++) {
			array[i] = sc.next();
		}
		for (i = 0; i < testcase; i++) {
			score = 0;
			total = 0;
			test = array[i];
			for (j = 0; j < test.length(); j++) {
				if (test.charAt(j) == 'O') {
					score++;
					total += score;
				} else {
					score = 0;
				}
			}
			System.out.println(total);
		}

	}
}
