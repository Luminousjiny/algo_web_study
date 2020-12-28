package day1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286 {
    static int N;
    static PriorityQueue<day1221.BOJ11286.Num> pq1; // Comparable 사용
    static PriorityQueue<Integer> pq2; // Comparator 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        /* 방법1 - Comparable 사용 */
        pq1 = new PriorityQueue<>();

        for (int i = 0; i < N; ++i) {
            int curr = Integer.parseInt(br.readLine());

            if (curr == 0) {
                sb.append(pq1.isEmpty() ? 0 : pq1.poll().n).append("\n");
            } else {
                pq1.add(new day1221.BOJ11286.Num(curr));
            }
        }

        /* 방법2 - Comparator 사용 */
        // Lambda
        pq2 = new PriorityQueue<>((a, b) -> {
            return Math.abs(a) == Math.abs(b) ? Integer.compare(a, b) : Integer.compare(Math.abs(a), Math.abs(b));
        });

        // Comparator
        pq2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2));
            }
        });

        for (int i = 0; i < N; ++i) {
            int curr = Integer.parseInt(br.readLine());

            if (curr == 0) {
                sb.append(pq2.isEmpty() ? 0 : pq2.poll()).append("\n");
            } else {
                pq2.add(curr);
            }
        }

        System.out.println(sb.toString());
    }

    static class Num implements Comparable<day1221.BOJ11286.Num> {
        int n;

        public Num(int n) {
            this.n = n;
        }

        @Override
        public int compareTo(day1221.BOJ11286.Num o) {
            if (Math.abs(this.n) == Math.abs(o.n))
                return Integer.compare(this.n, o.n);
            return Integer.compare(Math.abs(this.n), Math.abs(o.n));
        }
    }
}
