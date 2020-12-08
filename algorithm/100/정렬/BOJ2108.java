package day1208;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int array[] = new int[N];
		int count[] = new int[8001];
		int num, sum = 0, MIN = 4000, MAX = -4000, MaxCount = 0;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			array[i] = num;
			sum += num;
			if (num > MAX)
				MAX = num;
			if (num < MIN)
				MIN = num;
			count[4000 + num]++;
			if (count[4000 + num] > MaxCount)
				MaxCount = count[4000 + num];
		}
		int freqencyNum = 0, freqencyCount = 0;
		for (int i = MIN; i <= MAX && freqencyCount < 2; i++) {
			if (count[4000 + i] != MaxCount)
				continue;
			freqencyNum = i;
			freqencyCount++;
		}
		Arrays.sort(array);
		System.out.println(Math.round(1.0 * sum / N));
		System.out.println(array[N / 2]);
		System.out.println(freqencyNum);
		System.out.println(MAX - MIN);
	}
}