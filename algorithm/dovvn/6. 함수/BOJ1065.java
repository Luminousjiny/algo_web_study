import java.io.IOException;
import java.util.Scanner;

//한수
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int Ans = 0;
		
		for(int i=1; i<=num; i++) {
			if(i<=99) {
				Ans++;
				continue;
			}
			String s = Integer.toString(i);
			
			//등차수열인지 확인
			int d = (s.charAt(0)-'0')-(s.charAt(1)-'0');
			boolean isflag = true; //등차수열이면 true
			for(int j=1; j<s.length()-1; j++) {
				if(((s.charAt(j)-'0')-(s.charAt(j+1)-'0')) == d) continue;
				else {
					isflag = false;
					break;
				}
			}
			
			if(isflag) { //등차수열이면
				Ans++;
			}
		}
		System.out.println(Ans);
	}
}