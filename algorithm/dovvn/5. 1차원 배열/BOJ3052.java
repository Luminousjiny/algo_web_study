import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//3052 나머지
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[42]; //0~41
		
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			arr[num%42]++;
		}
		
		Arrays.sort(arr);
		int Ans = 0;
		for(int i=41; i>=0; i--) {
			if(arr[i] != 0) Ans++;
			if(arr[i] == 0) break;
		}
		System.out.println(Ans);
	}
}
