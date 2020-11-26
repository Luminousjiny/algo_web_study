package backjoon;

import java.util.Scanner;

public class BOJ2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();

        int res3 = a * (b % 10); // (3)에 들어갈 값
        int res4 = a * ((b % 100) / 10); // (4)에 들어갈 값
        int res5 = a * ((b % 1000) / 100); // (5)에 들어갈 값

        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res3 + (res4 * 10) + (res5 * 100));
    }
}
