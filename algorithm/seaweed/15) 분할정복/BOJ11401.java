package day0101;

import java.util.Scanner;

public class BOJ11401 {
    /**
     * nCr % P = (n! * ((n-r)! * r!)^(P-2)) % P
     */
    static int N, K;
    static long[] fact;
    static final int P = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; ++i) {
            fact[i] = (fact[i-1] * i) % P;
        }

        long ans = (((fact[N] * pow(fact[N-K], P - 2)) % P) * pow(fact[K], P - 2)) % P;

        System.out.println(ans);
    }

    static long pow(long a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a % P;

        long half = pow(a, b / 2);
        if (b % 2 == 0) {
            return (half * half) % P;
        } else {
            return (((half * half) % P) * a) % P;
        }
    }
}
