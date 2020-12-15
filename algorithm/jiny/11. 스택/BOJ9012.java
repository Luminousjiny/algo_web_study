package day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String S = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean ck = true;
            for (int j = 0; j < S.length(); j++) {
                char s = S.charAt(j);
                if(s == '('){
                    stack.push(s);
                }else{
                    if(stack.isEmpty()) {
                        ck = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty() || !ck) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
