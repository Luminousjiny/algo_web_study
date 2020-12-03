package day1203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1931 {
	static int N;
	static PriorityQueue<Conference> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			String[] time = br.readLine().split(" ");
			
			int start = Integer.parseInt(time[0]);
			int end = Integer.parseInt(time[1]);
			
			pq.add(new Conference(start, end));
		} // 입력 끝
		
		int confCnt = 0;
		int currEnd = -1;
		
		for(int i = 0; i < N; i++) {
			Conference curr = pq.poll();
			if(currEnd > curr.start) // 아직 회의가 안 끝난 경우
				continue;
			
			confCnt++; // 해당 회의 진행 가능시 진행
			currEnd = (int)curr.end; // 선택한 회의가 끝나는 시간으로 설정
		}
		System.out.println(confCnt);
	}
	
	static class Conference implements Comparable<Conference>{
		long start, end;
		
		Conference(long start, long end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Conference o) {
			if(this.end == o.end) {
				return Long.compare(this.start, o.start);
			}
			return Long.compare(this.end, o.end);
		}
		
	}
}
