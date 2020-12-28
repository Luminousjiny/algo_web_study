package day1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {
    static int TC, N, M;
    static Queue<int[]> queue;
    static LinkedList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; ++tc) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            list = new LinkedList<>(); // 우선순위 기준 내림차순

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; ++i) {
                int curr = Integer.parseInt(st.nextToken());
                queue.add(new int[]{curr, i});
                list.add(curr);
            } // 입력 끝

            list.sort(Collections.reverseOrder());

            int count = 1; // 몇번째에 출력하는지
            while (true) {
                // 우선순위 가장 높은 문서 찾기
                while (queue.peek()[0] != list.get(0)) {
                    queue.add(queue.poll());
                }

                if (queue.peek()[1] == M) {
                    // 원하던 문서 출력할 차례
                    sb.append(count).append("\n");
                    break;
                } else {
                    // 원하던 문서 아님
                    queue.poll();
                    list.pop();
                    ++count;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
