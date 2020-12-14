package day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String S = br.readLine();
            if(S.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            boolean ck = true;
            for (int i = 0; i < S.length(); i++) {
                char w = S.charAt(i);
                if (w == '.') { // 출력
                    if (!stack.isEmpty() || !ck) System.out.println("no");
                    else System.out.println("yes");
                    stack.clear();
                    ck = true;
                } else if (w == '(' || w == '[') {
                    stack.push(w);
                } else if (w == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') ck = false;
                    else stack.pop();
                } else if (w == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') ck = false;
                    else stack.pop();
                }
            }
        }

    }
}
