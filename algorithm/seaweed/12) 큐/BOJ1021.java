package day1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {
    static int N, M, ans;
    static LinkedList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new LinkedList<>();
        ans = 0;

        // 1 ~ N까지 리스트에 넣음
        for (int i = 1; i <= N; ++i) {
            list.addLast(i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        // M개 뽑기
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken());
            while (list.peek() != m) {
                if (list.indexOf(m) > list.size() / 2) {
                    list.addFirst(list.removeLast()); // 3
                } else {
                    list.addLast(list.removeFirst()); // 2
                }
                ++ans;
            }
            list.removeFirst(); // 1
        }

        System.out.println(ans);
    }
}
