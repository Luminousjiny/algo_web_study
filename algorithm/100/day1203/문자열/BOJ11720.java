import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		String Num = sc.next();
		int sum =0;
		int array[]= new int[N];
		for(int i = 0;i<N;i++)
		{
			array[i] = Integer.parseInt(Character.toString(Num.charAt(i)));
			sum+=array[i];
		}
		System.out.println(sum);
	}
}