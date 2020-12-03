import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		int Scount = Integer.valueOf(S);
		int result = Scount;
		for (int i = 0; i < Scount; i++) 
		{
			String S2 = sc.nextLine();
			int[] check = new int[26];
			for (int j = 1; j < S2.length(); j++) 
			{
				check[S2.charAt(0) - 'a'] = 1;
				if (S2.charAt(j) != S2.charAt(j - 1)) 
				{
					if (check[S2.charAt(j) - 'a'] == 0) 
					{
						check[S2.charAt(j) - 'a'] = 1;
					} 
					else 
					{
						result = result - 1;
						break;
					}
				}
			}
			check = new int[26];
		}
		System.out.println(result);
		sc.close();
	}
}