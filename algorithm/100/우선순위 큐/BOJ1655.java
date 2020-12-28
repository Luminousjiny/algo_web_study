package day1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1); // max힙을 위한 정렬
		PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2); // min힙을 위한 정렬

		//입력값을 하나씩 받을 때 마다 최대힙과 최소힙에 한 번씩 번갈아 가면서 넣어 주도록 한다. 
		//그렇게 될 경우 가운데에 있는 숫자는 왼쪽 최대힙의 root 값임
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(i%2 == 0) {//번갈아 가면서 넣어준다. 짝수일떄 max라고 가정하자.
				max.offer(num);
			} else {//min값이라고 가정한다.
				min.offer(num);
			}

			if(!max.isEmpty() && !min.isEmpty()) {
				if(max.peek() > min.peek()) { // swap
					int tmp = max.poll();
					max.offer(min.poll());
					min.offer(tmp);
				}
			}
			System.out.println(max.peek());
		}
		br.close();
	}
}