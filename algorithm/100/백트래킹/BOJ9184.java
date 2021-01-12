package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ9184 {

	static int[][][] dp = new int[21][21][21];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			/*
			 * 입력의 마지막은 -1 -1 -1로 나타내며, 세 정수가 모두 -1인 경우는 입력의 마지막을 제외하면 
			 * =>종료 조건.
			 * */
			if (a == -1 && b == -1 && c == -1) {
				break;
			}
			// 출력 양식
			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
		}
	}

	static int w(int a, int b, int c) { // 재귀 + 메모이제이션을 사용함
		if (inIn(a, b, c) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		if (a <= 0 || b <= 0 || c <= 0) {// 0 이하일 경우는 1을 반환하기 때문에
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) { //함수 w에서 a, b, c 중 20이 넘어가게 되면 w(20, 20, 20)을 호출
			return dp[20][20][20] = w(20, 20, 20);
		}
		if (a < b && b < c) { // 문제에 있던 조건으로.
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		// 문제에 있던 조건으로.
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

	static boolean inIn(int a, int b, int c) { // 범위 밖인지 판단하면 더 빠르다.
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
	}
}