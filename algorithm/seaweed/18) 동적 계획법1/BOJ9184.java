package day0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9184 {
    static int A, B, C;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        dp = new int[21][21][21];

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (A != -1 || B != -1 || C != -1) {
                /* 빠르다 */
                sb.append("w(").append(A).append(", ").append(B).append(", ").append(C).append(") = ").append(w(A, B, C)).append('\n');

                /* 많이 느리다 */
//                sb.append(String.format("w(%d, %d, %d) = ", A, B, C)).append(w(A, B, C)).append('\n');
            } else {
                break;
            }
        }
        System.out.println(sb.toString());
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if(dp[a][b][c] != 0)
            return dp[a][b][c];

        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return dp[a][b][c];
    }
}
