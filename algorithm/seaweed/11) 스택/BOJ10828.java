package day1214;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ10828 {
    /**
     * push X : 정수 X를 스택에 넣음
     * pop : 스택 가장 위에 있는 정수 빼고 출력. 없으면 -1 출력
     * size : 스택에 들어있는 정수의 개수 출력
     * empty : 스택 비어있으면 1, 아니면 0
     * top : 스택 가장 위에 있는 정수 출력. 들어있는 정수 없으면 -1 출력
     */
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        LinkedList<Integer> stack = new LinkedList<>();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String op = st.nextToken();

            switch (op) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
