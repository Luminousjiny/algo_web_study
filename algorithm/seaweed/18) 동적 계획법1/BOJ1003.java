package day0105;

import java.util.Scanner;

public class BOJ1003 {
    static final int MAX_SIZE = 40;
    static int TC, N;
    static int[][] fiboCnt; // f(0), f(1) 호출 횟수 저장
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        TC = sc.nextInt();

        fiboCnt = new int[2][MAX_SIZE + 1]; // 0 <= N <= 40
        fiboCnt[0][0] = 1; // f(0)
        fiboCnt[1][0] = 0;
        fiboCnt[0][1] = 0; // f(1)
        fiboCnt[1][1] = 1;

        for (int i = 2; i <= MAX_SIZE; ++i) {
            fiboCnt[0][i] = fiboCnt[0][i - 2] + fiboCnt[0][i - 1];
            fiboCnt[1][i] = fiboCnt[1][i - 2] + fiboCnt[1][i - 1];
        }

        for (int tc = 1; tc <= TC; ++tc) {
            N = sc.nextInt();

            sb.append(fiboCnt[0][N]).append(' ').append(fiboCnt[1][N]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
