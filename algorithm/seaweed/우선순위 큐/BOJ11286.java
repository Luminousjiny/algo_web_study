package day1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {
    static int N;
    static PriorityQueue<Num> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; ++i) {
            int curr = Integer.parseInt(br.readLine());

            if (curr == 0) {
                sb.append(pq.isEmpty() ? "0" : pq.poll().ogNum).append("\n");
            } else {
                pq.add(new Num(curr, Math.abs(curr)));
            }
        }
        System.out.println(sb.toString());
    }

    static class Num implements Comparable<Num> {
        int ogNum, absNum;

        public Num(int ogNum, int absNum) {
            this.ogNum = ogNum;
            this.absNum = absNum;
        }

        @Override
        public int compareTo(Num o) {
            if (this.absNum == o.absNum)
                return Integer.compare(this.ogNum, o.ogNum);
            return Integer.compare(this.absNum, o.absNum);
        }
    }
}
