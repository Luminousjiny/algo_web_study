package day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ4949 {
    /**
     * 소괄호, 대괄호 짝 맞추기
     */
    static LinkedList<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] curr;

        while ((curr = br.readLine().toCharArray())[0] != '.') {
            stack = new LinkedList<>();
            boolean isValid = true;

            for (char ch : curr) {
                switch (ch) {
                    case '(':
                    case '[':
                        stack.push(ch);
                        break;
                    case ')':
                        if(stack.isEmpty() || stack.peek() != '(')
                            isValid = false;
                        else
                            stack.pop();
                        break;
                    case ']':
                        if(stack.isEmpty() || stack.peek() != '[')
                            isValid = false;
                        else
                            stack.pop();
                        break;
                }
                if (!isValid)
                    break;
            }
            if(!stack.isEmpty())
                isValid = false;
            sb.append(isValid ? "yes" : "no").append("\n");
        }
        System.out.println(sb.toString());
    }
}
