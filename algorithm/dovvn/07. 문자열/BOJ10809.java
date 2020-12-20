import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alpha = new int[26]; //0~25
		Arrays.fill(alpha, -1);
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(alpha[c-97]==-1) {
				alpha[c-97] = i; //처음 등장하는 위치
			}
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(alpha[i]+" ");
		}
	}
}