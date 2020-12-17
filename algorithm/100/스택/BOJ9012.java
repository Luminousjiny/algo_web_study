package day1217;

import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int i = 0 ; i < T; i++) {
			Stack<Character> stack = new Stack<Character>();
			String str = scanner.next();
			for(int j = 0 ; j < str.length(); j++) {
				if(str.charAt(j) == '(') stack.add('(');
				else {
					if(stack.isEmpty()) stack.add(')');
					if(stack.peek() != ')') stack.pop();
				}
			}
			if(stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
		scanner.close();
	}
}
