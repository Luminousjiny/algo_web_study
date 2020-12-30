package day1229;

import java.util.Scanner;

public class BOJ1629 {
    /**
     * A^B 를 C로 나눈 나머지 구하기
     * A, B, C 최대 21억까지 가능
     */
    static int A, B, C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(pow(A, B));
    }

    static long pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % C;
        }
        long half = pow(a, b / 2) % C;
        if (b % 2 == 0)
            return (half * half) % C;
        else
            return (((half * half) % C) * a) % C;
    }
}
