package day1203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11399 {
	// i번째 사람이 인출하는데 걸리는 총 시간 = i-1번째 사람이 인출하는데 걸리는 시간 + i번째 사람이 뽑는 시간
	// 빨리 인출할 수 있는 사람부터 돈을 뽑으면 기다려야 하는 시간을 최소화 할 수 있다.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N]; // 인출하는데 걸리는 시간
		int[] time = new int[N]; // 각 사람이 인출하는데 필요한 시간의 합
		int totalTime = 0; // 모든 사람이 돈을 인출하는데 필요한 시간 합의 최솟값 
		
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(P); // 인출하는데 걸리는 시간 오름차순 정렬
		
		for(int i = 0; i < N; i++) {
			if(i == 0) {
				time[i] = P[i];
				totalTime += time[i];
				continue;
			}
			time[i] = time[i-1] + P[i];	// i번째 사람이 인출하는데 필요한 시간
			totalTime += time[i];
		}
		System.out.println(totalTime);
	}

}