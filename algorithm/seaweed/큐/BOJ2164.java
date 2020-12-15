package day1215;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {
    static int N, idx;
    static Queue<Integer> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = new LinkedList<>();

        N = sc.nextInt();
        // 1 ~ N 까지 카드 넣기
        for (int i = 1; i <= N; ++i) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
