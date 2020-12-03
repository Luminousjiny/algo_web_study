import java.util.Scanner;

//잃어버린 괄호
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		String[] str = s.split("-");
		int Ans = 0;
		//각 숫자 더하기
		for(int i=0; i<str.length; i++) {
			String ss = str[i];
			int sum = 0;
			
			String[] addNums = ss.split("\\+");
			for(int j=0; j<addNums.length; j++) sum += Integer.parseInt(addNums[j]);
			
			
			if(i==0) Ans = sum;
			else Ans-=sum;
		}
		System.out.println(Ans);
	}
}