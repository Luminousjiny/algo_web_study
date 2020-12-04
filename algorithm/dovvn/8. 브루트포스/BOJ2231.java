import java.io.IOException;
import java.util.Scanner;

//분해합
public class Main {
	
	static int N; //분해합
	static int M; //자릿수
	static int Ans; //가장 작은 생성자
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		boolean isFind = false;
		for(int i=1; i<N; i++) {
			int num = i;
			int sum = num;
			while(num != 0) {
				sum += num%10;
				num /= 10;
			}
			if(sum == N) {
				Ans = i;
				isFind = true;
				break;
			}
		}
		
		if(isFind) System.out.println(Ans);
		else System.out.println(0);
	}
}