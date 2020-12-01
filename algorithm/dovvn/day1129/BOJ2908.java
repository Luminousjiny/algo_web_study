import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

//상수
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		String inputA = st.nextToken();
		String inputB = st.nextToken();
		StringBuilder sbA = new StringBuilder();
		StringBuilder sbB = new StringBuilder();

		for(int i=2; i>=0; i--) {
			char a = inputA.charAt(i);
			char b = inputB.charAt(i);
			sbA.append(a);
			sbB.append(b);
		}
		int numA = Integer.parseInt(sbA.toString());
		int numB = Integer.parseInt(sbB.toString());
		
		if(numA > numB) System.out.println(numA);
		else System.out.println(numB);
	}
}