import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//동전0
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //종류
		long K = sc.nextInt(); //합
		
		long Ans = 0; //필요한 최소 동전개수
		
		List<Long> coins = new ArrayList<Long>();
		for(int i=0; i<N; i++) {
			long input = sc.nextLong();
			if(input <= K) coins.add(input);
		}//K이하 동전만 넣기
		
		Collections.sort(coins);
		for(int i=coins.size()-1; i>=0; i--) {
			if(coins.get(i)>K) continue;
			Ans += K / coins.get(i);
			K = K - coins.get(i) * (K/coins.get(i));
			if(K == 0) break;
		}
		System.out.println(Ans);
	}
}