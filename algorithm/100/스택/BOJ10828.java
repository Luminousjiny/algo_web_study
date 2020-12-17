package day1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10828 {
	public static void main(String[] args)throws IOException {		
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			if(str.contains("push")) {
				String[] addNumber = str.split(" ");
				stack.add(Integer.parseInt(addNumber[1]));
			}
			else if(str.equals("pop")) {
				if(stack.isEmpty()) System.out.println("-1");
				else System.out.println(stack.pop());
			}
			else if(str.equals("size")) {
				System.out.println(stack.size());
			}
			else if(str.equals("empty")) {
				if(stack.isEmpty()) System.out.println("1");
				else System.out.println("0");
			}
			else if(str.equals("top")) {
				if(stack.isEmpty()) System.out.println("-1");
				else System.out.println(stack.peek());
			}
		}
		br.close();
	}
}
