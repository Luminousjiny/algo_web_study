package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816 {
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		array = new int [N]; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) 
			array[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(array);
		
		int M = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine());
		int key, lower, upper;
		for (int i = 0; i < M; i++) {
			key = Integer.parseInt(st.nextToken());
			upper = upper_bound(key);
			lower = lower_bound(key);
			bw.append((upper - lower) + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static int upper_bound(int key) {
		int start = 0;
		int end = array.length-1;
		int mid;
		while(start < end) {
			mid = (start + end)/2;
			if(array[mid] > key)
				end = mid;
			else start = mid + 1;
		}
		if(array[end] == key) end++;
		return end;
	}
	private static int lower_bound(int key) {
		int start = 0;
		int end = array.length-1;
		int mid;
		while(start < end) {
			mid = (start + end)/2;
			if(array[mid] >= key)
				end = mid;
			else start = mid+1;
		}
		return end;
	}
	
}
