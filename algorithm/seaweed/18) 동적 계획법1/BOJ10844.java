package day0108;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10844 {
    static int N;
    static final int K = 1000000000;
    static long[] prev, curr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        prev = new long[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // 0으로 시작하는 숫자는 없기 때문
        curr = new long[10];

        for (int i = 1; i < N; ++i) {
            curr[0] = prev[1];
            curr[9] = prev[8];
            for (int j = 1; j <= 8; ++j) {
                curr[j] = (prev[j - 1] + prev[j + 1]) % K;
            }

            System.arraycopy(curr, 0, prev, 0, 10);
        }

        System.out.println(Arrays.stream(prev).reduce(0, (a, b) -> (a + b) % K));
    }
}