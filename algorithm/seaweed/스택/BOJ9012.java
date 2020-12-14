package day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ9012 {
    /**
     * 괄호 짝이 맞음   -> YES 출력
     * 괄호 짝이 안맞음 -> NO 출력
     */
    static int TC;
    static LinkedList<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            char[] ps = br.readLine().toCharArray(); // 괄호 문자열
            boolean isVPS = true;
            stack = new LinkedList<>();

            for (char p : ps) {
                if (p == ')') {
                    if(stack.isEmpty() || stack.peek() != '('){ // 스택이 비어있거나 VPS가 아닌 경우
                        isVPS = false;
                        break;
                    }
                    stack.pop();
                } else {
                    stack.push(p);
                }
            }
            if(!stack.isEmpty())
                isVPS = false;

            sb.append(isVPS ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}
