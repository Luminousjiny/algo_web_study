import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String array []= { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String S=scan.next();
		
		for(int i=0 ; i<array.length ;i++)
			S=S.replaceAll(array[i], "*");

		System.out.println(S.length());
	}

}