package day1231;

import java.util.Scanner;

public class BOJ1300 {
    /**
     * N x N 배열 A -> 1차원 배열 B (길이 : N x N)
     * A[i][j] = i * j
     * B[k] = ?
     * 1 <= N <= 100,000
     * 1 <= K <= min(10^9, N^2)
     * 
     * 아이디어 : 이분탐색을 이용해 현재 선택한 숫자가 B 배열의 몇번째 값이 되는지 찾아보기
     */
    static long N;
    static int K;
    static long ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        ans = Long.MAX_VALUE;

        findIdx(1, N * N);

        System.out.println(ans);
    }

    static void findIdx(long start, long end) {
        if (start > end) return;

        long mid = (start + end) / 2;

        long idx = 0; // mid 값 보다 작은 값들 개수
        for (int i = 1; i <= N; i++) {
            idx += (Math.min(N, mid / i)); // 현재 행에서 mid 값보다 작은 값 개수 구함
        }

        if (idx >= K) {
            ans = Math.min(ans, mid);
            findIdx(start, mid - 1);
        } else {
            findIdx(mid + 1, end);
        }
    }
}
