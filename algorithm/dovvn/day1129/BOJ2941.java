import java.util.Scanner;

//크로아티아 알파벳
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int Ans = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
 
			if(ch == 'c') {	
				if(i < s.length() - 1) {
					if(s.charAt(i + 1) == '=') {//다음 문자가 '=' 면
						i++; //건너뜀		
					}
					else if(s.charAt(i + 1) == '-') {
						i++;
					}
				}
			}
		    
			else if(ch == 'd') {
				if(i < s.length() - 1) {
					if(s.charAt(i + 1) == 'z') {
						if(i < s.length() - 2) {
							if(s.charAt(i + 2) == '='){// dz=
								i += 2;
							}
						}
					}
		        
					else if(s.charAt(i + 1) == '-') {// d-
						i++;
					}
				}
			}
		    
			else if(ch == 'l') {
				if(i < s.length() - 1) {
					if(s.charAt(i + 1) == 'j') {// lj
						i++;
					}
				}
			}
		    
			else if(ch == 'n') {
				if(i < s.length() - 1) {
					if(s.charAt(i + 1) == 'j') {// nj
						i++;
					}
				}
			}
 
			else if(ch == 's') {
				if(i < s.length() - 1) {
					if(s.charAt(i + 1) == '=') {// s=
						i++;
					}
				}
		    }
 
			else if(ch == 'z') {
				if(i < s.length() - 1) {
					if(s.charAt(i + 1) == '=') {// z=
						i++;
					}
				}
			}
		    
			Ans++;
 
		}
 
		System.out.println(Ans);
	}
}