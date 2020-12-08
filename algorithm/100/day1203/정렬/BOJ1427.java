import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        while(N>0)
        {
            stack.add((N%10));
            N/=10;
        }
        Collections.sort(stack);
        while(!stack.isEmpty())
            System.out.print(stack.pop());
    }
}