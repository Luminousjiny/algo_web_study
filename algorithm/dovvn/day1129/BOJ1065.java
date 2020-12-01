import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
			List<Integer> arr = new ArrayList<>();
			String s = Integer.toString(i);
			
			for(int j=0; j<s.length(); j++) {
				//각 자릿수 리스트에 넣기
				arr.add((int) (s.charAt(j)-'0'));
			}
			
			//등차수열인지 확인
			int d = arr.get(0)-arr.get(1);
			boolean isflag = true; //등차수열이면 true
			for(int j=1; j<arr.size()-1; j++) {
				if((arr.get(j)-arr.get(j+1)) == d) continue;
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