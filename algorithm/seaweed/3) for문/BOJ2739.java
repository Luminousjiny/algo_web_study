package day1126;

import java.util.Scanner;

public class BOJ2739 {
    /**
     * N을 입력받은 후 구구단 N단을 출력
     */
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 1; i < 10; i++){
            System.out.println(N + " * " + i + " = " + N * i);
        }
    }
}
