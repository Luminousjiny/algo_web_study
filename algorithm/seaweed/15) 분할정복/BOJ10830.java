package day1231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10830 {
    /**
     * N x N 행렬 A
     * A^B 를 구하라. 단 각 원소 1000으로 나눈 나머지 출력
     * 1 <= N <= 5
     * 1 <= B <= 100,000,000,000
     */
    static int N;
    static long B;
    static final int C = 1000;
    static long[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        //=== 데이터 입력 ===
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new long[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                A[i][j] = Integer.parseInt(st.nextToken()) % C; // 1000이 입력값으로 들어오는 경우 방지
            }
        }
        //=== 입력 끝 ===
        long[][] ans = pow(A, B);
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(ans[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static long[][] pow(long[][] a, long b) {
        if(b == 0) return getIdentity();
        if(b == 1) return a;

        long[][] half = pow(a, b / 2);
        if (b % 2 != 0) {
            return calculate(calculate(half, half), a);
        } else {
            return calculate(half, half);
        }
    }

    static long[][] calculate(long[][] a1, long[][] a2) {
        long[][] ret = new long[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                long sum = 0;
                for (int k = 0; k < N; ++k) {
                    sum += ((a1[i][k] * a2[k][j]) % C);
                }
                ret[i][j] = sum % C;
            }
        }
        return ret;
    }

    static long[][] getIdentity() {
        long[][] ret = new long[N][N];
        for (int i = 0; i < N; ++i) {
            ret[i][i] = 1;
        }
        return ret;
    }
}
