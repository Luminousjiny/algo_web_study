package day1126;

import java.util.Scanner;

public class BOJ8393 {
    /**
     * n이 주어졌을 때 1 ~ n의 합 구하기
     */
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 반복문
        int result = 0;
        for(int i = 1; i <= N; i++){
            result += i;
        }
        System.out.println(result);
        // 수학
//        System.out.println(N * (N + 1) / 2);
    }
}
