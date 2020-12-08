import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String args[]) throws IOException {
		

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] x = br.readLine().split(" ");
		int n1 = Integer.parseInt(x[0]);
		int n2 = Integer.parseInt(x[1]);
		String y = br.readLine();
		String[] A=y.split(" ");
		for(int i=0; i<n1; i++) {
			if(n2>Integer.parseInt(A[i])) {
				System.out.print(A[i]);
				System.out.print(" ");
			}
		}
		} 
	}
		