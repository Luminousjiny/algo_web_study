package day1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
// 최소 힙
public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                int size = pq.size();
                if(size == 0) {
                    sb.append(0).append("\n");
                } else if( size == 1){
                    sb.append(pq.poll()).append("\n");
                } else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.add(x);
            }
        }
        System.out.println(sb.toString());
    }
}
