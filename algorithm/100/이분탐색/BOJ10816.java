package 이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

Upper Bound와 Lower Bound는 이진탐색을 활용한 알고리즘
UpperBound와 LowerBound는 원하는 값을 초과하는 첫번째 위치, 원하는 값 이상의 첫번째 위치를 반환 함

정렬된 배열에서 찾고자 하는 값 key가 있을 때,
Upper Bound: key보다 큰 첫번째 위치(초과)를 반환.
Lower Bound: key보다 크거나 같은 첫번째 위치(이상)를 반환.


*/

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
