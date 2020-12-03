import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		String s = sc.next();
		int i,k = 0;
        int array[] = new int[26];
        Arrays.fill(array, -1);
        for (i = 0; i < s.length(); i++) {
            k = (int)(s.charAt(i) - 'a');
            if(array[k]==-1)
            array[k]=i;
        }
        for(i=0;i<array.length;i++)
        	System.out.print(array[i]+" ");
	}
}