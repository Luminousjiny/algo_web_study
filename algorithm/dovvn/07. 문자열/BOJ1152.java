import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

//단어의 개수
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int Ans = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			Ans++;
		}
		System.out.println(Ans);
	}
}