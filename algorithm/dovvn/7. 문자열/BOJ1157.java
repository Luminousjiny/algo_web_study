import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//단어 공부
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] alpha = new int[26]; //대문자 A(65), 소문자 a(97)
		int max = 0; //가장 많이 사용한 알파벳
		int maxIdx = 0;
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 97) { //소문자
				alpha[c-97]++;
				if(max < alpha[c-97]) {
					max = alpha[c-97];
					maxIdx = c-97;
				}
			}else { //대문자
				alpha[c-65]++;
				if(max < alpha[c-65]) {
					max = alpha[c-65];
					maxIdx = c-65;
				}
			}
		}
		boolean isflag = false;
		for(int i=0; i<26; i++) { //여러개인지 검사
			if(i == maxIdx) continue;
			if(alpha[maxIdx] == alpha[i]) {
				isflag = true;
				break;
			}
		}
		if(isflag) System.out.println("?");
		else System.out.println((char)(maxIdx+65));
	}
}