import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//최소, 최대
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int[] copy = new int[9];
		
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt(); //input
			copy[i] = arr[i];
		}
		
		Arrays.sort(arr); //오름차순
		for(int i=0; i<arr.length; i++) {
			if(arr[8] == copy[i]) {
				System.out.println(arr[8]);
				System.out.println(i+1);
				break;
			}
		}
	}
}
