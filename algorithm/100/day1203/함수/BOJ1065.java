import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		answer = checkHanNumber(N);
		System.out.println(answer);
		sc.close();
	}

	private static int checkHanNumber(int n) {
		int check = 99;
		int Num = n;
		int array[] = new int[3];
		if (0 < Num && Num < 100)
			check = Num;
		else {
			for (int i = 100; i <= n; i++) {
				array[0] = i % 10;
				array[1] = (i / 10) % 10;
				array[2] = (i / 100) % 10;
				if(i==1000)
					break;
				if ((array[2] - array[1]) == (array[1] - array[0]))
					check++;
			}
		}
		return check;
	}
}