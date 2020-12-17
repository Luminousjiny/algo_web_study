package day1217;
import java.util.Scanner;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            Stack<Character> stack = new Stack<>();
            String str = scanner.nextLine();
            if(str.equals(".")) break;
            for(int j = 0 ; j < str.length(); j++)
            {
                if(str.charAt(j)=='(' || str.charAt(j)=='[') {
                    stack.add(str.charAt(j));
                }
                else if(str.charAt(j)==')') {
                    if (stack.isEmpty() || stack.peek() == '[')
                    {
                        stack.add(str.charAt(j));
                        break;
                    }
                    stack.pop();
                }
                else if(str.charAt(j)==']')
                {
                    if(stack.isEmpty() || stack.peek() =='(')
                    {
                        stack.add(str.charAt(j));
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty())
                System.out.println("yes");
            else System.out.println("no");
        }
        scanner.close();
    }
}