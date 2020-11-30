import java.io.IOException;
import java.util.Scanner;

//2577 숫자의 개수
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10]; //0~9
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		String result = Integer.toString(A*B*C);
		
		for(int i=0; i<result.length(); i++) {
			int num = result.charAt(i)-'0';
			arr[num]++;
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
