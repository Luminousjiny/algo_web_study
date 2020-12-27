package day1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder()); // 중앙값보다 작은수 -> 역순으로 저장
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(); // 중앙값보다 큰수
        StringBuilder sb = new StringBuilder();

        // pq1 과 pq2 를 번갈아가면서 넣고
        // pq1.peek() 과 pq2.peek() 비교해서
        // pq1.peek() > pq2.peek() 이면 swap
        // pq1.peek() 이 항상 중앙값
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(i%2 == 0) pq1.add(num);
            else pq2.add(num);

            if(!pq1.isEmpty() && !pq2.isEmpty()){
                if(pq1.peek() > pq2.peek()) {
                    int tmp = pq1.poll();
                    pq1.add(pq2.poll());
                    pq2.add(tmp);
                }
            }
            sb.append(pq1.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
