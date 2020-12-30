package day1229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    /**
     * N x N 행렬
     * -1, 0, 1
     */
    static int N;
    static int[] nums;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        nums = new int[] {0, 0, 0};

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calculate(0, 0, N);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    static void calculate(int si, int sj, int size) {
        if (size == 1) {
            nums[paper[si][sj] + 1]++;
            return;
        }
        if (check(si, sj, size)) {
            nums[paper[si][sj] + 1]++;
            return;
        }

        calculate(si, sj, size / 3);
        calculate(si, sj + size / 3, size / 3);
        calculate(si, sj + 2 * size / 3, size / 3);
        calculate(si + size / 3, sj, size / 3);
        calculate(si + size / 3, sj + size / 3, size / 3);
        calculate(si + size / 3, sj + 2 * size / 3, size / 3);
        calculate(si + 2 * size / 3, sj, size / 3);
        calculate(si + 2 * size / 3, sj + size / 3, size / 3);
        calculate(si + 2 * size / 3, sj + 2 * size / 3, size / 3);
    }

    static boolean check(int si, int sj, int size) {
        int data = paper[si][sj];

        for (int i = si; i < si + size; ++i) {
            for (int j = sj; j < sj + size; j++) {
                if(data != paper[i][j])
                    return false;
            }
        }
        return true;
    }
}
