package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2740 {
    /**
     * N x M, M x K 행렬의 곱
     *
     * A * B = C
     */
    static int N, M, K;
    static int[][] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        /* 캐시 활용한 방법 - row-major 인 경우 효과 큼(C, C++ 등) */
        //=== 데이터 입력 ===
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        A = new int[N][M];
//
//        for (int i = 0; i < N; ++i) {
//            st = new StringTokenizer(br.readLine(), " ");
//            for (int j = 0; j < M; ++j) {
//                A[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        st = new StringTokenizer(br.readLine(), " ");
//        M = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        B = new int[K][M];
//
//        for (int i = 0; i < M; ++i) {
//            st = new StringTokenizer(br.readLine(), " ");
//            for (int j = 0; j < K; ++j) {
//                B[j][i] = Integer.parseInt(st.nextToken());
//            }
//        }
//        // === 입력 끝 ===
//        for (int i = 0; i < N; ++i) {
//            for (int k = 0; k < K; ++k) {
//                int sum = 0;
//                for (int j = 0; j < M; ++j) {
//                    sum += A[i][j] * B[k][j];
//                }
//                sb.append(sum).append(" ");
//            }
//            sb.append("\n");
//        }
        
        /* 일반적인 방법 */
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; ++j) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = new int[M][K];

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < K; ++j) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // === 입력 끝 ===
        for (int i = 0; i < N; ++i) {
            for (int k = 0; k < K; ++k) {
                int sum = 0;
                for (int j = 0; j < M; ++j) {
                    sum += A[i][j] * B[j][k];
                }
                sb.append(sum).append(" ");
            }
            sb.append("\n");
        }

        /* 결과 출력 */
        System.out.println(sb.toString());
    }
}
