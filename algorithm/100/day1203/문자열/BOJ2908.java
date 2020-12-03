import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S1 = sc.next();
		String S2 = sc.next();
		S1 = reverse(S1);
		S2 = reverse(S2);
		int i1, i2 = 0;
		i1 = Integer.parseInt(S1);
		i2 = Integer.parseInt(S2);
		if (i1 < i2)
			System.out.println(S2);
		else
			System.out.println(S1);
		sc.close();
	}

	public static String reverse(String re) {
		String S = "";
		for (int i = re.length() - 1; i >= 0; i--) {
			S += re.charAt(i);
		}
		return S;
	}
}