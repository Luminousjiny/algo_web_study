import java.io.IOException;
import java.util.Scanner;

//덩치
public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Man[] arr = new Man[N];
		
		for(int i=0; i<N; i++) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			arr[i] = new Man(w, h);
		}
		
		for(int i=0; i<N; i++) {
			Man m = arr[i];
			int k = 1;
			for(int j=0; j<N; j++) {
				if(j==i) continue;
				Man o = arr[j];
				if(m.w<o.w && m.h<o.h) k++;
			}
			System.out.print(k+" ");
		}
	}
	
	static class Man{
		int w;
		int h;
		
		public Man(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}
}