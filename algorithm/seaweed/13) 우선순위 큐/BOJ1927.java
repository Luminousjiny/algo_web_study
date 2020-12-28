package day1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
    static int N;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; ++i) {
            int curr = Integer.parseInt(br.readLine());
            if (curr == 0) {
                sb.append(pq.isEmpty() ? "0" : pq.poll()).append("\n");
            } else {
                pq.add(curr);
            }
        }
        System.out.println(sb.toString());
    }
}
