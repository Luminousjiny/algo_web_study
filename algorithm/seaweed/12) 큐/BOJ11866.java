package day1216;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11866 {
    /**
     * 요세푸스 문제
     */
    static int N, K;
//    static LinkedList<Integer> list;
    static Queue<Integer> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
//        list = new LinkedList<>();
        queue = new LinkedList<>();

        N = sc.nextInt();
        K = sc.nextInt();

        // 1 ~ N 까지 넣기
        for (int i = 1; i <= N; ++i) {
//            list.add(i);
            queue.add(i);
        }

        // 요세푸스 순열 만들기
        sb.append("<");
        /* queue 사용 X */
//        int idx = 0;
//        while (list.size() > 0) {
//            idx = (idx + K - 1) % list.size();
//
//            sb.append(list.remove(idx));
//            sb.append(list.size() == 0 ? "" : ", ");
//        }

        /* queue 사용 O */
        while (!queue.isEmpty()) {
            for (int k = 0; k < K - 1; ++k) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            sb.append(queue.isEmpty() ? "" : ", ");
        }
        sb.append(">");

        System.out.println(sb.toString());
    }
}
