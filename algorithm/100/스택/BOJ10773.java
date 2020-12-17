package day1217;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++)
        {
            int input = Integer.parseInt(br.readLine());
            if(input == 0)stack.pop();
            else stack.add(input);
        }
        int total = 0;
        for(int Num : stack)
            total +=Num;
        System.out.println(total);
    }
}