import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//블랙잭
public class Main {
	
	static int N; //카드개수
	static int M; //합
	static int[] cards;//전체 카드
	static int[] selected; //선택한 카드
	static int Ans; //최대한 M과 가까운 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		cards = new int[N];
		selected = new int[3];
		
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}//End input
		
		//조합ㄱㄱ
		cur(0, 0);
		System.out.println(Ans);
	}

	private static void cur(int cur, int cnt) {
		if(cnt == 3) {
			int sum = 0;
			for(int i=0; i<3; i++) {
				sum += cards[selected[i]];
			}
			if(sum<=M && Ans<sum) {
				Ans=sum;
			}
			return;
		}
		
		for(int i=cur; i<N; i++) {
			selected[cnt] = i;
			cur(i+1, cnt+1);
		}
	}
}