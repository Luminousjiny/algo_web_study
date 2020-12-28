package day1129;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720 {
    /**
     * N개의 숫자가 주어졌을 때 이 숫자를 모두 더한 합을 구하시오
     * 1 <= N <= 100
     */
    static int N, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        result = 0;

        for(int i = 0; i < N; i++){
            result += (numbers.charAt(i) - '0');
        }
        System.out.println(result);
    }
}
