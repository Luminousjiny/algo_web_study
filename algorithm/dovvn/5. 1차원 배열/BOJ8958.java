import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//OX퀴즈
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			String s = sc.next();
			
			int score = 0; //현재 까지 온 점수
			int Ans = 0;
			
			int[] scores = new int[s.length()];
			
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c == 'O') {//O
					score++;
					scores[i] = score;
				}else {//X
					score = 0;
				}
			}
			
			
			for(int i : scores) Ans += i;
			System.out.println(Ans);
		}
	}
}