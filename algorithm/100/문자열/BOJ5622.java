import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		char array[]= sc.next().toCharArray();
		int sum = 0;
		for (int i =0;i<array.length;i++) 
		{
			sum += 2;
			switch (array[i]) {
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
				sum += 1;
			case 'T':
			case 'U':
			case 'V':
				sum += 1;
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				sum += 1;
			case 'M':
			case 'N':
			case 'O':
				sum += 1;
			case 'J':
			case 'K':
			case 'L':
				sum += 1;
			case 'G':
			case 'H':
			case 'I':
				sum += 1;
			case 'D':
			case 'E':
			case 'F':
				sum += 1;
			case 'A':
			case 'B':
			case 'C':
				sum += 1;
			}
		}
		System.out.println(sum);
	}
}
