package day1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(
        		(o1, o2) -> Math.abs(o1) == Math.abs(o2) ?//절대값이 같은가 여러개인 경우라면?
                		Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
                		//Integer.compare()를 활용해 만약 o1과 o2의 절대 값이 같다면 실제 숫자를 기준으로 오름차순으로 정렬해주고, 
                		//아니라면 절대값을 기준으로 오름차순으로 정렬되도록 하였다
        );
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
            	if(queue.size() == 0) 
            		System.out.println(0);
            	else 
            		System.out.println(queue.poll());
            }
            else queue.offer(num);
        }
    }
}