package day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ10773 {
    /**
     * 잘못된 수 0 -> 최근 쓴 숫자 제거
     */
    static int K, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> stack = new LinkedList<>();

        K = Integer.parseInt(br.readLine());
        sum = 0;

        for (int i = 0; i < K; i++) {
            int curr = Integer.parseInt(br.readLine());

            if (curr == 0) {
                sum -= stack.pop();
            } else {
                stack.push(curr);
                sum += curr;
            }
        }
        System.out.println(sum);
    }
}
