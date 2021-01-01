package day0101;

import java.util.Scanner;

public class BOJ2749_pisano {
    /**
     * 피사노 주기를 이용한 해결 방법
     *
     * N번째 피보나치 수를 M으로 나눈 나머지를 구할 때
     * M = 10^k (k > 2)라면 주기는 항상 15*10^(k-1)
     */
    static long N;
    static int targetIdx;
    static int[] fibo;
    static final int M = 1000000;
    static final int PERIOD = 1500000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();
        targetIdx = (int)(N % PERIOD);
        fibo = new int[PERIOD];
        fibo[1] = 1;

        for (int i = 2; i <= targetIdx; ++i) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % M;
        }

        System.out.println(fibo[targetIdx]);
    }
}
