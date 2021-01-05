package day0105;

import java.util.Scanner;

public class BOJ9461 {
    /**
     * P(N) : 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, ...
     * P(N) = P(N - 1) + P(N - 5)
     */
    static final int MAX_SIZE = 100;
    static int TC, N;
    static long[] P;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        TC = sc.nextInt();
        P = new long[MAX_SIZE + 1];
        P[0] = 1;
        P[1] = 1;
        P[2] = 1;
        P[3] = 2;
        P[4] = 2;

        for (int i = 5; i <= MAX_SIZE; ++i) {
            P[i] = P[i - 1] + P[i - 5];
        }

        for (int tc = 1; tc <= TC; ++tc) {
            sb.append(P[sc.nextInt() - 1]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
