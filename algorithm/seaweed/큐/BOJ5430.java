package day1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ5430 {
    /**
     * R : 뒤집기
     * D : 맨 앞에 하나 빼기 -> 비어있는 상태에서 사용시 error출력
     */
    static int TC, N;
    static String ops; // 수행할 함수들 1 ~ 100,000개
    static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; ++tc) {
            ops = br.readLine();
            N = Integer.parseInt(br.readLine());
            String tmp = br.readLine();
            st = new StringTokenizer(tmp.substring(1, tmp.length()-1), ",");

            deque = new LinkedList<>();
            for (int n = 0; n < N; ++n) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            int reverseCnt = 0;
            boolean isError = false;
            for (int n = 0; n < ops.length(); ++n) {
                if(isError)
                    break;
                switch (ops.charAt(n)) {
                    case 'R':
                        ++reverseCnt;
                        break;
                    case 'D':
                        if (reverseCnt % 2 == 0) {
                            if (deque.isEmpty()) {
                                isError = true;
                            } else {
                                deque.pollFirst();
                            }
                        } else {
                            if (deque.isEmpty()) {
                                isError = true;
                            } else {
                                deque.pollLast();
                            }
                        }
                        break;
                }
            }
            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (reverseCnt % 2 == 0) {
                    while (deque.size() > 1) {
                        sb.append(deque.pollFirst()).append(",");
                    }
                    sb.append(deque.isEmpty() ? "" : deque.pollFirst());
                } else {
                    while (deque.size() > 1) {
                        sb.append(deque.pollLast()).append(",");
                    }
                    sb.append(deque.isEmpty() ? "" : deque.pollLast());
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}
