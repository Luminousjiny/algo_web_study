import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Test = N;
		int A = 0;// 10의자리
		int B = 0;// 1의자리
		int C = 0;// A+B의 합
		int count = 0;
		while (true) {
			A = Test / 10;
			B = Test % 10;
			C = A + B;
			Test = (B * 10) + (C % 10);
			count++;
			if (N == Test) {
				System.out.println(count);
				break;
			}
		}

	}
}
