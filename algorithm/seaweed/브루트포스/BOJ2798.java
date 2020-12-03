package day1203;

import java.util.Scanner;

public class BOJ2798 {
	/*
	 * N장의 카드 중 3개를 선택해 M에 최대한 가까운 수를 만들 것
	 * 3 <= N <= 100
	 * 10 <= M <= 300,000
	 */
	static int N, M, ans;
	static int[] selected;
	static int[] cards;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = 0;
		cards = new int[N];
		selected = new int[3];
		
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		combination(0, 0);
		System.out.println(ans);
	}
	
	static void combination(int cnt, int curr) {
		if(cnt == 3) {
			int tmp = 0;
			for(int i = 0; i < 3; i++) {
				tmp += selected[i];
			}
			
			if(tmp <= M)
				ans = Math.max(ans, tmp);
			
			return;
		}
		
		for(int i = curr; i < N; i++) {
			selected[cnt] = cards[i];
			combination(cnt + 1, i + 1);
		}
	}
}
