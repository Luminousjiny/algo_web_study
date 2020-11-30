	import java.util.Scanner;
	
	//셀프넘버
	public class Main {
		static boolean[] arr = new boolean[100001]; //1~10000
		public static void main(String[] args) {
			for(int i=1; i<=10000; i++) {
				d(i);
			}
			
			for(int i=1; i<=10000; i++) {
				if(!arr[i]) { //false
					System.out.println(i);
				}
			}
		}
		
		static void d(int n) { //각 자리수 더함
			int sum = n;
			
			while(true) {
				if(n==0) break;
				sum += n%10;
				n/=10;
			}
			
			if(sum <= 10000) {
				arr[sum] = true; //생성자 있음
			}
		}
	}