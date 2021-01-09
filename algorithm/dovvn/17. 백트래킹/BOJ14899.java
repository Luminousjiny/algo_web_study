import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] S;
	static int Ans; // 스타트-링크 차이 최소
	static boolean[] selected;
	static boolean[] visited;
	static int[] result;
	static int[] two;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N + 1][N + 1]; // 1번~N번

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Ans = Integer.MAX_VALUE;
		selected = new boolean[N];
		two = new int[2];
		divide(0, 0);
		System.out.println(Ans);
	}

	static void divide(int target, int cnt) { // 뽑은 개수, 시작숫자
		if (cnt == N / 2) {
			int[] trueArr = new int[N/2];
			int[] falseArr = new int[N/2];
			
			int j=0;
			int k=0;
			for(int i=0; i<N; i++) {
				if(selected[i]) trueArr[j++] = i+1;
				if(!selected[i]) falseArr[k++] = i+1;
			}
			visited = new boolean[N/2];
			sum = 0;
			getSum(0, trueArr);
			int trueSum = sum;
			
			visited = new boolean[N/2];
			sum = 0;
			getSum(0, falseArr);
			int falseSum= sum;
			
			Ans = Math.min(Math.abs(trueSum-falseSum), Ans);
			return;
		}

		if (target == N) {
			return;
		}
		
		if(cnt==0 && target>=N/2-1) return;
		selected[target] = true;
		divide(target + 1, cnt + 1);
		sum = 0;
		selected[target] = false;
		divide(target + 1, cnt);
		sum = 0;
	}

	// 능력치의 합을 구함
	private static void getSum(int cnt, int[] numbers) {
		if(cnt == 2) {//2개 모두 뽑았으면
			sum += S[two[0]][two[1]];
			return;
		}
		
		for(int i=0; i<N/2; i++) {
			if(visited[i]) continue;
			two[cnt] = numbers[i];
			getSum(cnt+1, numbers);
			visited[i] = false;
		}
	}
}