import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//동전1
public class Main {
	
	static int n, k; //동전종류, 가치의 합
	static int[] coins;
	static int[] dp;//인덱스: 만들 동전 가치, 값: 경우의수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		coins = new int[n];
		dp = new int[k+1];
		
		for(int i=0; i<n; i++) coins[i] = Integer.parseInt(br.readLine()); //End input
		
		dp[0] = 1;//동전 0원 만들 수 있는 경우 
		
		//가치의 합이 k가 되는 경우의 수 구하기(중복 선택 가능)
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j-coins[i] >= 0) dp[j] += dp[j-coins[i]]; 
			}
		}//End input
		
		System.out.print(dp[k]);
	}
}
