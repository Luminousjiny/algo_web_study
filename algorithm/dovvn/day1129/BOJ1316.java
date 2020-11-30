import java.io.IOException;
import java.util.Scanner;

//1316 그룹단어체커
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int Ans = num; //전체 단어 갯수
		
		for(int i=0; i<num; i++) {
			String s = sc.next();
			boolean[] alpha = new boolean[26]; //나온 문자 true
			
			for(int j=1; j<s.length(); j++) {
				if(s.charAt(j-1) != s.charAt(j)) { //현재 문자와 이전 문자가 다르다면
					//현재 문자가 이전에 나왔다면
					if(alpha[s.charAt(j)-'a'] == true) {
						Ans--; //그룹문자 아님
						break;
					}
					alpha[s.charAt(j-1)-'a'] = true;
				}
			}
		}
		System.out.println(Ans);
	}
}
