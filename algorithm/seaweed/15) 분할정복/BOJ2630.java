package day1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2630 {
    /**
     * 0 : 흰색
     * 1 : 파란색
     */
    static int N, cntWhite, cntBlue;
    static char[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        paper = new char[N][N];
        cntWhite = 0;
        cntBlue = 0;

        for (int i = 0; i < N; ++i) {
            paper[i] = br.readLine().replaceAll(" ", "").toCharArray();
        }

        checkPaper(0, 0, N);

        System.out.println(cntWhite);
        System.out.println(cntBlue);
    }

    static void checkPaper(int si, int sj, int size) {
        if (size == 1) {
            if (paper[si][sj] == '0')
                ++cntWhite;
            else
                ++cntBlue;
            return;
        }

        if (check(si, sj, size)) {
            if (paper[si][sj] == '0')
                ++cntWhite;
            else
                ++cntBlue;
        } else {
            checkPaper(si, sj + size / 2, size / 2); // 1 사분면
            checkPaper(si, sj, size / 2);// 2 사분면
            checkPaper(si + size / 2, sj, size / 2);// 3 사분면
            checkPaper(si + size / 2, sj + size / 2, size / 2);// 4 사분면
        }
    }

    static boolean check(int si, int sj, int size) {
        char color = paper[si][sj];
        for (int i = si; i < si + size; ++i) {
            for (int j = sj; j < sj + size; ++j) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
