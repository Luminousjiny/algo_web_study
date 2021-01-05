package 이분탐색;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		Arrays.sort(array);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(Integer.parseInt(st.nextToken()), array));
		}
	}

    public static int binarySearch(int number, int[] array)
    {
        int first =0;
        int last =array.length-1;
        int mid  = 0;

        while(first <= last)
        {
            mid = (first+last)/2;
            if(number == array[mid]) return 1;
            else if(number < array[mid])
            last = mid-1;
            else first = mid+1;
        }
        return 0;
    }
}
