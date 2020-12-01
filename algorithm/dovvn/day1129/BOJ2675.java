import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문자열 반복
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			//각 문자를 R번 반복해 새 문자열 P만듦
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				for(int j=0; j<R; j++) System.out.print(c);
			}
			System.out.println();
		}
	}
}