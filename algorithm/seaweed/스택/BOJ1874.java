package day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ1874 {

    static int N, currNum;
    static LinkedList<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean isValid = true;
        N = Integer.parseInt(br.readLine());
        currNum = 0;
        stack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int curr = Integer.parseInt(br.readLine());
            while (currNum < curr) {
                stack.push(currNum + 1);
                sb.append("+\n");
                ++currNum;
            }

            if (stack.peek() == curr) {
                stack.pop();
                sb.append("-\n");
            } else {
                isValid = false;
            }
        }
        System.out.println(isValid ? sb.toString() : "NO");
    }
}
